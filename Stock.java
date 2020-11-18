/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package officesoftware;

/**
 *
 * @author mpun0
 */
class Stock {
    private Integer catid;
    private String catName;
    Integer items_id;
    String itemName;
    Integer purchase_id;
    Integer stock_id;
    Integer borrow_id;
    
    // this is for category only//
    public Stock(Integer catid , String catName){
        this.catid  = catid;
        this.catName= catName;   
    }
    //this is for Items only//
    public Stock(Integer item_id, String itemName,Integer cat_id){
        this.items_id = item_id;
        this.catid = catid;
        this.itemName = itemName;
        
    }

    /**
     * @return the catid
     */
    public Integer getCatid() {
        return catid;
    }

    /**
     * @param catid the catid to set
     */
    public void setCatid(Integer catid) {
        this.catid = catid;
    }

    /**
     * @return the catName
     */
    public String getCatName() {
        return catName;
    }

   
 


    
}
