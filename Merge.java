package sort;

public class Merge {
	
	private Merge() {}
	
	public static void sort(Comparable[] a) {
//		int N=a.length;
		sort(a,0,a.length-1);
	}
	
	private static void sort(Comparable[] a,int lo,int hi) {
		if(lo>=hi) {
			return;
		}
		int mid=(lo+hi)/2;
		sort(a,lo,mid);
		sort(a,mid+1,hi);
		merge(a,lo,mid,hi);
	}
	
	private static void merge(Comparable[] a,int lo,int mid,int hi) {
		Comparable[] b=new Comparable[a.length];
		for(int i=lo;i<=hi;i++) {
			b[i]=a[i];
		}
		int first=lo,second=mid+1;

		for(int i=lo;i<=hi;i++) {
			if(second>hi) {
				a[i]=b[first++];
			}else if(first>mid) {
				a[i]=b[second++];
			}else if(b[first].compareTo(b[second])>=0) {
				a[i]=b[second++];
			}else {
				a[i]=b[first++];
			}
		}
	}

}
