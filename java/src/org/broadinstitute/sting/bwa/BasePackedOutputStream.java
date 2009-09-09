package org.broadinstitute.sting.bwa;

import org.broadinstitute.sting.utils.StingException;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * A general-purpose stream for writing packed bases.
 *
 * @author mhanna
 * @version 0.1
 */
public class BasePackedOutputStream<T> {
    /**
     * Type of object to pack.
     */
    private final Class<T> type;

    /**
     * How many bases can be stored in the given data structure?
     */
    private final int basesPerType;

    /**
     * Ultimate target for the packed bases.
     */
    private final OutputStream targetOutputStream;

    /**
     * A fixed-size buffer for word-packed data.
     */
    private final ByteBuffer buffer;

    public BasePackedOutputStream( Class<T> type, File outputFile, ByteOrder byteOrder ) throws FileNotFoundException {
        this(type,new BufferedOutputStream(new FileOutputStream(outputFile)),byteOrder);
    }

    /**
     * Write packed bases to the given output stream.
     * @param type Type of data to pack bases into.
     * @param outputStream Output stream to which to write packed bases.
     * @param byteOrder Switch between big endian / little endian when reading / writing files.
     */
    public BasePackedOutputStream( Class<T> type, OutputStream outputStream, ByteOrder byteOrder) {
        this.targetOutputStream = outputStream;
        this.type = type;
        basesPerType = PackUtils.bitsInType(type)/PackUtils.BITS_PER_BASE;
        this.buffer = ByteBuffer.allocate(basesPerType/PackUtils.ALPHABET_SIZE).order(byteOrder);
    }

    /**
     * Writes an array of bases to the target output stream.
     * @param bases List of bases to write.
     * @throws IOException if an I/O error occurs.
     */
    public void write( byte[] bases ) throws IOException {
        int packedBases = 0;
        int positionInPack = 0;

        for(byte base: bases) {
            packedBases = packBase(base, packedBases, positionInPack);

            // Increment the packed counter.  If all possible bases have been squeezed into this byte, write it out.
            positionInPack = ++positionInPack % basesPerType;
            if( positionInPack == 0 ) {
                writePackedBases(packedBases);
                packedBases = 0;
            }
        }

        if( positionInPack > 0 )
            writePackedBases(packedBases);
    }

    /**
     * Flush the contents of the OutputStream to disk.
     * @throws IOException if an I/O error occurs.
     */
    public void flush() throws IOException {
        targetOutputStream.flush();
    }

    /**
     * Closes the given output stream.
     * @throws IOException if an I/O error occurs.
     */
    public void close() throws IOException {
        targetOutputStream.close();
    }

    /**
     * Pack the given base into the basepack.
     * @param base The base to pack.
     * @param basePack Target for the pack operation.
     * @param position Position within the pack to which to add the base.
     * @return The packed integer.
     */
    private int packBase( byte base, int basePack, int position ) {
        basePack |= (PackUtils.packBase(base) << 2*(basesPerType-position-1));
        return basePack;
    }    

    /**
     * Write the given packed base structure to the output file.
     * @param packedBases Packed bases to write.
     * @throws IOException on error writing to the file.
     */
    private void writePackedBases(int packedBases) throws IOException {
        buffer.rewind();
        if( type == Integer.class )
            buffer.putInt(packedBases);
        else if( type == Byte.class )
            buffer.put((byte)packedBases);
        else
            throw new StingException("Cannot pack bases into type " + type.getName());
        targetOutputStream.write(buffer.array());        
    }
}
