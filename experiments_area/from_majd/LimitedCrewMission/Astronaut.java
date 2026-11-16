public class Astronaut {
    

private String name;
private static int Max_Astronauts=4;
private static int recuitedCount=0;

private Astronaut(String name){

    this.name=name;
}

public static Astronaut recruit(String name){

if(recuitedCount<Max_Astronauts){
    recuitedCount++;

    System.out.printf("Recruited astronaut #%d: %s\n",recuitedCount,name);
Astronaut newAstronaut=new Astronaut(name);

return newAstronaut;
}
else
{

    System.out.printf("Crew is full: cannot recruit %s\n",name);
    return null;

}



}

public static int getRecruitedCount(){
    return recuitedCount;
}

public String getName(){

    return name;

}



}
