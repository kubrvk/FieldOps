package com.fieldops.audit.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.fieldops.audit.FieldOpsApp
import com.fieldops.audit.data.entity.InventoryItem
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var app: FieldOpsApp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        app = application as FieldOpsApp

        // Sample offline record insertion
        lifecycleScope.launch {
            app.database.inventoryDao().insertItem(
                InventoryItem(
                    barcode = "8690123456789",
                    sku = "SKU-HOTEL-LINEN-01",
                    itemName = "Premium Room Bedspread",
                    countedQuantity = 24,
                    latitude = 36.8841,
                    longitude = 30.7056
                )
            )
        }
    }
}
