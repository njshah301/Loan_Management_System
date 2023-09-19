import { useEffect, useState } from "react";
import { item_data_by_id,item_edit } from "./api";
import { Navigate, useNavigate } from "react-router-dom";
import { useLocation } from "react-router-dom";

const ItemEdit = () => {
  const navigate=useNavigate();
  const location=useLocation();
  const [item_id, setItem_id] = useState(location.state.Id);
  const [item_category,setItem_category] = useState('');
  const [item_description,setItem_description] = useState('');
  const [item_valuation,setItem_valuation] = useState('');
  const [issue_status,setIssue_status] = useState('');
  const [item_make,setItem_make] = useState('');
  useEffect(() => {
    return async () => {
      const response= await item_data_by_id(item_id);
      setItem_category(response.category);
      setItem_description(response.description);
      setItem_valuation(response.value);
      setIssue_status(response.status);
      setItem_make(response.make);
    };
  }, []);
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

   // e.preventDefault();

  const handleItemEdit = async (e) => {
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
    await item_edit(item_id,data);
    navigate('/item_display');
  }



  return(
    <div>
        {/* <NavBar/> */}
        <h1>Loan Management Application</h1>
        <h2> Item Master Data Details</h2>
        <form onSubmit={handleItemEdit}>
        <h4> Item Id
                <input type="text" value={item_id} className="ItemId" onChange={onItemIdChange} disabled></input>
                </h4>
                <h4> Item Category
                <select name="ItemCategory" className="ItemCategory"  value={item_category} defaultValue={item_category} onChange={onItemCategoryChange}  required>
                    <option value="">--Select Item category--</option>
                    <option value="furniture">Furniture</option>
                    <option value="stationary">Stationary</option>
                    <option value="crockery">Crockery</option>
                </select>
                </h4>
                <h4> Item Description
                    <input type="text" value={item_description} className="ItemDescription"  onChange={onItemDescriptionChange} required></input>
                </h4>
                <h4> Item Valuation
                    <input type="text" value={item_valuation} className="ItemValuation"  onChange={onItemValuationChange}  required></input>
                </h4>
                <h4> Item Status
                <select name="ItemStatus" className="ItemStatus" value={issue_status}  defaultValue={issue_status} onChange={onItemStatusChange} required>
                    <option value="">--Select Item status--</option>
                    <option value="yes">Yes</option>
                    <option value="no">No</option>
                </select>
                </h4>
                <h4> Item Make
                <select name="ItemMake" className="ItemMake" value={item_make}  defaultValue={item_make} onChange={onItemMakeChange} required>
                    <option value="">--Select Item make--</option>
                    <option value="wooden">Wooden</option>
                    <option value="glass">Glass</option>
                    <option value="plastic">Plastic</option>
                </select>
                </h4>
            <button type="submit">Edit Data</button>
        </form>
    </div>
)
};
export default ItemEdit;