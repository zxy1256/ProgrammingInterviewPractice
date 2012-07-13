package ch2;

import java.util.List;

/**
 * 
 * @author sean
 *
 */
public interface Matrix {
	public Double get(final int i, final int j);
	public void set(final int i, final int j, final double value);
	public List<Integer> getSize();
	public int getRowSize();
	public int getColumnSize();
	public String toString();
}
