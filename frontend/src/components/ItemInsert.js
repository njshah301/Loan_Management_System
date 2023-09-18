import { Outlet, Link } from "react-router-dom";
import { useState } from "react";
import { item_insert } from "./api";
import NavBar from "./NavBar";
import { Navigate, useNavigate } from "react-router-dom";

const ItemInsert=()=>{
     const navigate=useNavigate();
     const [item_id, setItem_id] = useState("");
     const [item_category, setItem_category] = useState("");
     const [item_description, setItem_description] = useState("");
     const [item_valuation, setItem_valuation] = useState("");
     const [issue_status,setIssue_status]= useState("");
     const [item_make,setItem_make]=useState("");
      const onItemIdChange = (e) => {
        setItem_id(e.target.value);
      };
      const onItemCategoryChange = (e) => {
        setItem_category(e.target.value);
      };
      const onItemDescriptionChange = (e) => {
        setItem_description(e.target.value);
      };
      const onItemValuationChange = (e) => {
        setItem_valuation(e.target.value);
      };
      const onItemStatusChange = (e) => {
        setIssue_status(e.target.value);
      };
      const onItemMakeChange = (e) => {
        setItem_make(e.target.value);
      };
    
      const handleItemInsert = async (e) => {
        e.preventDefault();
        const data={
          itemid:item_id,
          category:item_category,
          description:item_description,
          value:item_valuation,
          status:issue_status,
          make:item_make
        };
        console.log(data);
        await item_insert(data);
        navigate('/item_display');
      }
    return(
        <div>
            <NavBar/>
            <h1>Loan Management Application</h1>
            <h2> Item Master Data Details</h2>
            <form onSubmit={handleItemInsert}>
                <h4> Item Id
                    <input type="text" className="ItemId" onChange={onItemIdChange} required></input>
                </h4>
                <h4> Item Category
                <label>
                <select className="ItemCategory" onChange={onItemCategoryChange} required>
                    <option value="">--Select Item category--</option>
                    <option value="furniture">Furniture</option>
                    <option value="stationary">Stationary</option>
                    <option value="crockery">Crockery</option>
                </select>
                </label>
                </h4>
                <h4> Item Description
                    <input type="text" className="ItemDescription" onChange={onItemDescriptionChange} required></input>
                </h4>
                <h4> Item Valuation
                    <input type="text" className="ItemValuation" onChange={onItemValuationChange} required></input>
                </h4>
                <h4> Item Status
                <label>
                <select className="ItemStatus" onChange={onItemStatusChange} required>
                    <option value="">--Select Item status--</option>
                    <option value="yes">Yes</option>
                    <option value="no">No</option>
                </select>
                </label>
                </h4>
                <h4> Item Make
                <label>
                <select className="ItemMake" onChange={onItemMakeChange} required>
                    <option value="">--Select Item make--</option>
                    <option value="wooden">Wooden</option>
                    <option value="glass">Glass</option>
                    <option value="plastic">Plastic</option>
                </select>
                </label>
                </h4>
                <button type="submit">Add Data</button>
            </form>
        </div>
    )
}

export default ItemInsert;