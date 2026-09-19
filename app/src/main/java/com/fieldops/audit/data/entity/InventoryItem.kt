package com.fieldops.audit.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "inventory_items")
data class InventoryItem(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val barcode: String,
    val sku: String,
    val itemName: String,
    val countedQuantity: Int,
    val latitude: Double?,
    val longitude: Double?,
    val timestamp: Long = System.currentTimeMillis(),
    val isSynced: Boolean = false
)
