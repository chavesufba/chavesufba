package br.com.keysufba.domain;

public enum RoomType {

  /*
   * Classroom
   */
  R,
  
  /*
   * Class Lab
   */
  C,
  
  /*
   * Student Lab
   */
  S;
  
  public int getCode() {
    return this.ordinal();
  }
  
  public String getDescryption() {
    switch(this) {
    case R:
      return "Classroom";
    case C:
      return "Class Laboratory";
    case S:
      return "Student Laboratory";
    default:
      return "";
    }
  }
}
