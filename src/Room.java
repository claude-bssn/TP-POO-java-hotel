package src;

public class Room {
  private Boolean isAvailable;
  private Boolean isClean;
  private String name;


  /**
   * @param p_name is the name/number of the room
   * @param p_isAvailable determine vacancy of the room
   * @param p_isClean determine if the room is clean
   */
  public Room(String p_name, Boolean p_isAvailable, Boolean p_isClean){
    setName(p_name);
    setIsAvailable(p_isAvailable);
    setIsClean(p_isClean);
  }
  
  /**
   * @return boolean member isAvailable
   */
  public Boolean getIsAvailable() {
    return isAvailable;
  }

  /**
   * @param p_isAvailable has to be a boolean
   * will be set to the Room member isAvailable 
   */
  public void setIsAvailable(Boolean p_isAvailable) {
    this.isAvailable = p_isAvailable;
  }

  /**
   * @return will return boolean isClean
   */
  public Boolean getIsClean() {
    return isClean;
  }

  /**
   * @param p_isClean has to be a boolean
   * will be set to the Room member isClean 
   */
  public void setIsClean(Boolean p_isClean) {
    this.isClean = p_isClean;
  }
  
  /**
   * @return will return room name has a String
   */
  public String getName() {
    return name;
  }

  /**
   * @param name has to be a String
   * will set name of the room
   */
  public void setName(String p_name) {
    this.name = p_name;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
   
      StringBuilder resultString = new StringBuilder();
      resultString.append("Room : ");
      resultString.append(this.name  + " ");
      resultString.append("Available: ");
      resultString.append(this.isAvailable  + " ");
      resultString.append("Clean: ");
      resultString.append(this.isClean + " ");
    return resultString.toString(); 


  }
}
