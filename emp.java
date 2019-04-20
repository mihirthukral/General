class emp{
  public static void main(String a[]){
    int c= Integer.parseInt(a[0]);
    System.out.println("age= "+c+" gender= "+a[1]+" marital status= "+a[2]);
    String name="Married";
    String n="unmarried";
    String h=a[1];
    char d=h.charAt(0);
    if(name.equalsIgnoreCase(a[2])){
      System.out.println("user is eligible for insurance");
    }
    else if(n.equalsIgnoreCase(a[2]) && c>30 && d=='m' || n.equalsIgnoreCase(a[2]) && c>25 && d=='f'){
      System.out.println("user is eligible for insurance");
    }
    else{
      System.out.println("user is not eligible for insurance");
  }
}
}
