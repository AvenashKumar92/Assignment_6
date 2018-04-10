package com.example.avenash_2.walmartextendedapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ElectronicsActivity extends AppCompatActivity {

    List<Product> products=new ArrayList<>();
    static ElectronicsActivity electronicsActivity;
    ListView lvElectronics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electronics);
        electronicsActivity=this;
        initProductList();
        lvElectronics=findViewById(R.id.lvElectronics);
        lvElectronics.setAdapter(new ElectronicsListAdapter());
        lvElectronics.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getApplicationContext(), ElectronicsProductDVActivity.class);
                intent.putExtra("Key", products.get(position));
                startActivity(intent);
            }
        });
    }

    void initProductList(){
        addTablet();
        addLaptop();
        addLEDTV();
        addPrinter();
        addScanner();
    }

    void addTablet(){
        Product product=new Product();
        product.setItemId(R.drawable.tablet);
        product.setImage(getResources().getResourceName(R.drawable.tablet));
        product.setTitle("Galaxy Tab S3");
        product.setPrice(100.00);
        product.setColor("White");
        product.setDescription("For the first time, enjoy the sleekness of a smartphone with all the benefits of a tablet. " +
                "The glossy glass back of the Galaxy Tab S3 provides a premium look that also feels premium in your hands.");
        products.add(product);
    }

    void addLaptop(){
        Product product=new Product();
        product.setItemId(R.drawable.laptop);
        product.setTitle("Lenovo - 15.6 Laptop - AMD A6-Series - 4GB Memory - 500GB Hard Drive - Black");
        product.setImage(getResources().getResourceName(R.drawable.laptop));
        product.setPrice(850.00);
        product.setColor("Black");
        product.setDescription("Lenovo 110-15ACL Laptop: Enjoy productivity anywhere with this 15.6-inch Lenovo Ideapad laptop. Its 500GB of storage holds plenty of large applications and documents, and its built-in optical drive lets you read and write digital files. " +
                "The quad-core AMD A6 processor and 4GB of RAM let this Lenovo Ideapad laptop run Windows 10 smoothly.");
        products.add(product);
    }
    void addPrinter(){
        Product product=new Product();
        product.setItemId(R.drawable.printer);
        product.setImage(getResources().getResourceName(R.drawable.printer));
        product.setTitle("Canon Pixma TR8520 Wireless Home Office All-In-One Printer");
        product.setPrice(50.00);
        product.setColor("Black");
        product.setDescription("Excellent print quality. Light and compact. SD card slot. Ethernet support. " +
                "Two black inks. Two paper input trays. 20-sheet ADF. XXL ink cartridges available.");
        products.add(product);
    }
    void addLEDTV(){
        Product product=new Product();
        product.setItemId(R.drawable.led);
        product.setImage(getResources().getResourceName(R.drawable.led));
        product.setTitle("BRAVO 24 inch Full HD LED TV - BLE24F7760");
        product.setPrice(35.00);
        product.setColor("Brown");
        product.setDescription("Main reasons to Buy your new BRAVO 24 inch LED Display in Kuwait online from Xcite with the best price in Kuwait and enjoy free delivery. " +
                "Start shopping online now!");
        products.add(product);
    }
    void addScanner(){
        Product product=new Product();
        product.setItemId(R.drawable.scanner);
        product.setImage(getResources().getResourceName(R.drawable.scanner));
        product.setTitle("Epson Perfection V19 Scanner");
        product.setPrice(25.00);
        product.setColor("Black");
        product.setDescription("The affordable, compact Epson Perfection V19 offers easy scanning and sharing. " +
                "Whether you're scanning photos or documents, the V19 delivers 4800 x 4800 dpi resolution1 and fast speeds. ");
        products.add(product);
    }

    class ElectronicsListAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return products.size();
        }

        @Override
        public Object getItem(int position) {
            return products.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater layoutInflater=LayoutInflater.from(ElectronicsActivity.electronicsActivity);
            View view=layoutInflater.inflate(R.layout.itemelectronicslist, null);
            ImageView imageView=view.findViewById(R.id.ivElectronicProduct);
            TextView txtProductTitle=view.findViewById(R.id.lblElecProductName);
            TextView txtColor=view.findViewById(R.id.lblElecProductColor);
            TextView txtPrice=view.findViewById(R.id.lblElecProductPrice);

            txtColor.setText(txtColor.getText() + products.get(position).getColor());
            txtPrice.setText(txtPrice.getText() + String.valueOf(products.get(position).getPrice()));
            txtProductTitle.setText(products.get(position).getTitle());
            imageView.setImageResource(products.get(position).getItemId());
            return view;
        }
    }
}
