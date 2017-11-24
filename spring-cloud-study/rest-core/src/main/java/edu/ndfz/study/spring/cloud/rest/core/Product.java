package edu.ndfz.study.spring.cloud.rest.core;

@SuppressWarnings("unused") public class Product {

  private static final long serialVersionUID = 1L;

  // ========================================================================
  // fields =================================================================
  private String itemCode;                                    // 产品货号
  private String name;                                        // 产品名称
  private String bandName;                                    // 产品品牌名称
  private int price;                                          // 产品价格(分)

  // ========================================================================
  // constructor ============================================================
  public Product() {
  }

  public static long getSerialVersionUID() {
    return serialVersionUID;
  }

  public String getItemCode() {
    return itemCode;
  }

  public void setItemCode(String itemCode) {
    this.itemCode = itemCode;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getBandName() {
    return bandName;
  }

  public void setBandName(String bandName) {
    this.bandName = bandName;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public Product(String itemCode, String name, String bandName, int price) {
    this.itemCode = itemCode;
    this.name = name;
    this.bandName = bandName;
    this.price = price;
  }
}
