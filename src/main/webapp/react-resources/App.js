import React from 'react';
import DataGrid from 'devextreme-react/data-grid';

const columns = ['CompanyName', 'City', 'State', 'Phone', 'Fax'];

class App extends React.Component {
  render() {
    return (
      <DataGrid
        dataSource="https://js.devexpress.com/Demos/WidgetsGallery/JSDemos/data/customers.json"
        defaultColumns={columns}
        showBorders={true}
      />
    );
  }
}

export default App;
