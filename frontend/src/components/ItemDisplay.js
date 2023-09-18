import { useEffect, useState } from "react";
import { item_data,item_delete } from "./api";
import NavBar from "./NavBar";
import { Navigate, useNavigate } from "react-router-dom";
const ItemDisplay = () => {
  const [items, setItems] = useState([]);
    const navigate=useNavigate();
  useEffect(() => {
    return async () => {
      const response = await item_data();
      setItems(response);
    //   console.log("This is from useEffect", response);
    };
  }, [items]);

  const handleItemDelete = async (item_id) => {
    // e.preventDefault();
    await item_delete(item_id);
  };

  const handleItemEdit=async(item_id)=>{
    navigate('/item_edit',{state:{Id:item_id}});

   // e.preventDefault();
  }



  return (
    <div className="container">
      <NavBar/>
      <h3>Items List</h3>
      <table>
        <thead>
          <tr>
            <th>Item Id</th>
            <th>Item Category</th>
            <th>Item Description</th>
            <th>Item Valuation</th>
            <th>Issue Status</th>
            <th>Item Make</th>
          </tr>
        </thead>
        <tbody>
        {items.map((item) => (
            <tr key={item.itemid}>
              <td>{item.itemid}</td>
              <td>{item.category}</td>
              <td>{item.description}</td>
              <td>{item.value}</td>
              <td>{item.status}</td>
              <td>{item.make}</td>
              <td>
                <button onClick={()=>handleItemEdit(item.itemid)}> Edit</button>
                <button onClick={()=>handleItemDelete(item.itemid)}> Delete </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default ItemDisplay;