package project1;

public class Name implements Comparable<Name>{
    private String first_name;
    private String middle_name;
    private String last_name;

    public Name(String first_name, String middle_name, String last_name) {
        this.first_name = first_name;
        this.middle_name = middle_name;
        this.last_name = last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
    
    public boolean equals(Name other){
        if(other == null)
            throw new NullPointerException("object is missing");
        
        return(this.first_name.equals(other.getFirst_name()) & 
                this.middle_name.equals(other.getMiddle_name()) & 
                this.last_name.equals(other.getLast_name()));
    }
    
    @Override
    public String toString(){
        return("" + this.first_name + " " + this.middle_name + " " + this.last_name);
    }
    
    @Override
    public int compareTo(Name other){
        if(other == null)
            throw new NullPointerException("object is missing");
        
        return(this.first_name.compareTo(other.getFirst_name()) &
                this.middle_name.compareTo(other.getMiddle_name()) &
                this.last_name.compareTo(other.getLast_name()));
    }
}
