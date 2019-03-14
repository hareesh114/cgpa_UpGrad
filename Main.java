import java.util.*;

class Event implements Comparable<Event>{
	int index;
	String name;
	double cgpa;
	Event(int index,String name,double cgpa){
		this.index = index;
		this.name = name;
		this.cgpa = cgpa;
	}

	public int compareTo(Event e){
		int compare = Double.compare(cgpa,e.cgpa);
		return compare;
	}

	String getName(){
		return this.name;
	}
	int getIndex(){
		return this.index;
	}
}


public class Main{


	public static void main(String[] args) {
		int count=0;
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Event> list = new ArrayList<Event>();
		for(int i=0;i<=n;i++){
			String input = sc.nextLine();
			String arr[]=input.split("[ ]+");
			if(arr[0].equals("ENTER")){
				count+=1;
				list.add(new Event(i,arr[1],Double.parseDouble(arr[2])));
			}
			else if(arr[0].equals("SERVED")){
				if(count != 0){
					Collections.sort(list,Collections.reverseOrder());
					
					list.sort(new Comparator<Event>(){
						public int compare(Event e1,Event e2){
						int comparision = 0;
						comparision = e1.getName().compareTo(e2.getName());
						if(comparision == 0){
							comparision = Integer.compare(e1.getIndex(),e2.getIndex());
						}
						return comparision;
			 
			}
					});

					list.remove(0);
					}
				else{
					System.out.println("EMPTY");
				}
				}
				
		}
		Collections.sort(list,Collections.reverseOrder());
			for (Event j : list){
                System.out.println(j.name);
            }
		 	
	}
}