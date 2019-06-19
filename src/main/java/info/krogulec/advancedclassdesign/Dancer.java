package info.krogulec.advancedclassdesign;

public abstract class Dancer {
    public Leader getPartner(){
        return new Leader();
    }

    abstract public Leader getPartner(int count);
}

 class SwingDancer extends Dancer{
    public Follower getPartner(){
        return new Follower();
    }

     @Override
     public Leader getPartner(int count) {
         return new Leader();
     }
 }

class Leader{}
class Follower extends Leader{}

class Stage{
    public static void main(String[] args) {
        Dancer dancer = new SwingDancer();
        Leader partner = dancer.getPartner();
        Leader partner1 = dancer.getPartner(2);

        System.out.println(partner);
        System.out.println(partner1);
    }
}
