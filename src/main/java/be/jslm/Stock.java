package Hello;

@Entity
public class Stock {

  @Id
  private Long id;
  private String name;

  public Stock(){}

  public Stock(String name, Set closeQuotes){
    this.name = name;
    this.closeQuotes = closeQuotes;
  }


}
