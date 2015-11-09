package org.tendiwa.geometry.grid.gridMasks;

/**
 * @author Georgy Vlasov (suseika@tendiwa.org)
 * @version $Id$
 * @since 0.1.0
 */
public interface GridMask {
    boolean contains(int x, int y);
}
