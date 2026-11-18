import java.util.ArrayList;
public class Spaceship {
    String name;
    private LifeSupport lifeSupport;
    private ArrayList<Astronaut> crew;

    public Spaceship(String name){
        this.name=name;
        System.out.println("[Spaceship] Building "+name+"...");

        this.lifeSupport=new LifeSupport();
        this.crew=new ArrayList<>();
    }

    public void boardCrew(Astronaut astronaut){
        if(astronaut==null){
            System.out.println(this.name+": no astronaut to board");
        }else if (crew.size()<3){
            crew.add(astronaut);
            System.out.println("Borded "+astronaut.getName()+" on "+this.name+ " s(eat "+crew.size()+" of 3)");
        }else{
            System.out.println(this.name+" is full: "+astronaut.getName()+" stays behind");
        }
    }

    public void printManifest(){
        System.out.println(this.name+" crew: ");
        if (crew.isEmpty()){
            System.out.println("none");
            return;
        }
        for(int i=0; i<crew.size();i++){
            System.out.print(crew.get(i).getName()+" , ");
        }
        System.out.println();

    }

    
}
