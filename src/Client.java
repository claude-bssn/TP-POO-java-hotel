package src;

import java.util.UUID;

public class Client {
  private String nameClient;  
  private UUID idClient;

  
  /**
   * generate an anonymous client with a unique id
   */
  public Client() {
    setNameClient("John Doe");
    setIdClient(UUID.randomUUID());
  }

  /**
   * @param p_client will be affected to client nameClient
   * the client idClient will be generated for every class instanciation 
   */
  public Client(String p_client) {
    setNameClient(p_client);
    setIdClient(UUID.randomUUID());
  }

  /**
   * @return will return client nameClient
   */
  public String getNameClient() {
    return nameClient;
  }

  /**
   * @param p_name will affect a name to Client
   */
  protected void setNameClient(String p_name) {
    this.nameClient = p_name;
  }

  /**
   * @return will return Client id 
   * will be useful when clients have an account
   */
  public String getIdClient() {
    return idClient.toString();
  }

  /**
   * @param p_id will affect the generated uniq id to the client
   */
  protected void setIdClient(UUID p_id) {
    this.idClient = p_id;
  }
  
  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   * override in class to string for Client return client name and id as string
   */
  @Override
  public String toString() {
    StringBuilder result = new StringBuilder();
    result.append("client name: ");
    result.append(this.nameClient);
    result.append("\n");
    result.append("client id: ");
    result.append(this.idClient);
    result.append("\n");
  return result.toString(); 
   
  }

}
