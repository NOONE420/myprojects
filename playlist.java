import java.util.Scanner;
import java.util.Random;
public class playlist{
    public static int display(node head){
        node temp3=head;
        System.out.println("\tPLAYLIST");
        int i=0;
        while(temp3!=null){
            i++;
            System.out.println(i+". "+temp3.name);
            temp3=temp3.next;
        }
        return i;
    }
    public static void main(String args[]){
        Scanner scn=new Scanner(System.in);
        node head=null;
        node tail=null;
        node temp=null;
        node temp2=null;
        
        int i;
        int n=0;
        while(n!=5){
            System.out.println("\n\tPlaylist Menu");
            System.out.print("1. Create\n2. Add\n3. Delete\n4. Shuffle\n5. Exit\n: ");
            n=scn.nextInt();
            scn.nextLine();

            if(n==1){
                System.out.print("\nNo of songs: ");
                int n2=scn.nextInt();
                scn.nextLine();

                for (i=0;i<n2;i++){
                    System.out.print("Song "+(i+1)+": ");
                    String data=scn.nextLine();

                    node newNode=new node(data);
                    if (head==null){
                        head=newNode;
                        tail=newNode;
                    }
                    else{
                        tail.next=newNode;
                        tail=tail.next;
                    }
                }

                System.out.println("\nCREATED!");
                display(head);
            }

            else if(n==2){
                if(head==null){
                    System.out.println("\nPlaylist is Empty!");
                }
                else{
                    display(head);

                    System.out.print("\nName: ");
                    String data=scn.nextLine();
                    System.out.print("Position: ");
                    int n3=scn.nextInt();
                    scn.nextLine();

                    node newNode=new node(data);
                    int size=display(head);
                    if(n3>=size){
                        tail.next=newNode;
                        tail=tail.next;

                        System.out.println("\nADDED!");
                        display(head);
                    }

                    else{
                        temp=head;
                        temp2=null;

                        if (n3==1){
                            newNode.next=head;
                            head=newNode;

                            System.out.println("\nADDED!");
                            display(head);
                        }
                        else{
                            for (i=1;i<(n3-1);i++){
                                temp=temp.next;
                            }

                            temp2=temp.next;
                            temp.next=newNode;
                            temp=temp.next;
                            temp.next=temp2;

                            System.out.println("\nADDED!");
                            display(head);
                        }
                    }
                }
            }
            else if(n==3){
                if(head==null){
                    System.out.println("\nPlaylist is Empty!");
                }
                else{
                    display(head);
                    
                    System.out.print("\nPosition: ");
                    int n3=scn.nextInt();
                    scn.nextLine();

                    if(n3==1){
                        head=head.next;

                        System.out.println("\nDELETED!");
                        display(head);
                    }
                    else{
                        temp=head;
                        temp2=null;
                        i=1;
                        while(i!=(n3-1)){
                            temp=temp.next;
                            i++;
                        }
                        temp2=temp.next;
                        temp2=temp2.next;
                        temp.next=temp2;

                        System.out.println("\nDELETED!");
                        display(head);
                    }
                }
            }
            else if(n==4){
                if(head==null){
                    System.out.println("\nPlaylist is Empty!");
                }
                else{
                    Random random=new Random();
                    int size=display(head);
                    int n1=random.nextInt(1,size+1);
                    int n2=random.nextInt(1,size+1);

                    while (n1==n2){
                        n1=random.nextInt(1,size+1);
                        n2=random.nextInt(1,size+1);
                    }

                    temp=head;
                    for(i=0;i<(n1-1);i++){
                        temp=temp.next;
                    }

                    temp2=head;
                    for(i=0;i<(n2-1);i++){
                        temp2=temp2.next;
                    }

                    String temp4=temp.name;
                    temp.name=temp2.name;
                    temp2.name=temp4;                    

                    System.out.println("\nSHUFFLED!");
                    display(head);

                }
            }
            else if(n==5){
                continue;
            }
            else{
                System.out.println("\nINVALID!");
            }
        }
    }
}

class node{
    public String name;
    public node next;

    node(String b){
        this.name=b;
        this.next=null;
    }
}
