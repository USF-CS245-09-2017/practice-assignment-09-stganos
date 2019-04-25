import java.util.*;

public class BinaryHeap
{
	//HeapArray
	int[] HeapArray = new int[10];
	int size = 0;


	public void add(int value)
	{
		//doubles array length if at the max
		if (size >= HeapArray.length - 1)
		{
			int[] temp = new int[(HeapArray.length * 2)];
			for (int i = 0; i < HeapArray.length; i++)
			{
				temp[i] = HeapArray[i];
			}
			HeapArray = temp;
		}

		HeapArray[size++] = value;
		int curr = size - 1;
		int parent = (curr - 1)/2;
		
		//continuously swaps with parent if less than parent, or until it is at the root
		while (HeapArray[curr] < HeapArray[parent] && curr != 0)
		{
			swap(HeapArray, curr, parent);
			curr = parent;
			parent = (curr - 1)/2;
		}//while

	}//add

	//remove root and then replace with end element
	public int remove()
	{
		//throws out of bounds exception when there is nothing to remove
		if (size == 0)
		{
			throw new ArrayIndexOutOfBoundsException();
		}//if

		else
		{
			swap(HeapArray, 0, --size);
			if (size > 0)
			{
				shiftdown(HeapArray, 0);
			}//if
			return HeapArray[size];
		}//else

	}//remove

	//swaps with smallest child recursively
	private void shiftdown(int[] array, int shift)
	{
		//gets smallest child if there is one
		int smallest = getSmallest(array, shift);

		if(smallest != shift)
		{
			swap(array, shift, smallest);
			shiftdown(array, smallest);
		}//if
	}//shiftdown

	//swap 2 elements in an array
	private void swap(int[] arr, int pos1, int pos2)
	{
		int temp;
		temp = arr[pos1];
		arr[pos1] = arr[pos2];
		arr[pos2] = temp;
	
	}//swap

	private int getSmallest(int[] arra, int index)
	{
		int smallIndex = index;
		
		//when left child exists and less than parent
		if ((arra[(2*index) + 1] < 0) && (arra[(2*index) + 1]) < arra[index])
		{
			smallIndex = arra[(2*index) + 1];
		}//if
		
		//when right child exists and less than parent and less than the parent's left child
		if ((arra[(2*index) + 2] < 0) && (arra[(2*index) + 2]) < (arra[(2*index) + 1]) && (arra[(2*index) + 2] < arra[index]))
		{
			smallIndex = arra[(2*index) + 2];
		}//if
		
		return smallIndex;
	
	}//getSmallest

}//class