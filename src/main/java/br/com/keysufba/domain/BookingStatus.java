package br.com.keysufba.domain;

public enum BookingStatus {

  /*
   * Pending
   */
  P,
  
  /*
   * Accepted
   */
  A,
  
  /*
   * Refused
   */
  R;
  
  public int getCode() {
    return this.ordinal();
  }
  
  public String getDescryption() {
    switch(this) {
    case P:
      return "Pending";
    case A:
      return "Accepted";
    case R:
      return "Refused";
    default:
      return "";
    }
  }
}
