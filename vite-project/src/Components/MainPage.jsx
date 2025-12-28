import React from 'react';
import classes from './MainPage.module.css';

class MainPage extends React.Component {
   render() {
      const menu = ["Shirts", "Pants", "Jackets", "Accessories"];
      return (
      <div>
         <h3 className = {classes.MainPageHeading}>Route Runner Shop</h3>
         <ol>
            <li className={classes.menuText}>{menu[0]}</li>
            <li className={classes.menuText}>{menu[1]}</li>
            <li className={classes.menuText}>{menu[2]}</li>
            <li className={classes.menuText}>{menu[3]}</li>

         </ol>
      </div>
      );
   }
}

export default MainPage;