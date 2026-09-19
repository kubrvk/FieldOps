package com.fieldops.audit.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.fieldops.audit.data.dao.InventoryDao
import com.fieldops.audit.data.entity.InventoryItem

@Database(entities = [InventoryItem::class], version = 1, exportSchema = false)
abstract class AuditDatabase : RoomDatabase() {

    abstract fun inventoryDao(): InventoryDao

    companion object {
        @Volatile
        private var INSTANCE: AuditDatabase? = null

        fun getDatabase(context: Context): AuditDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AuditDatabase::class.java,
                    "fieldops_audit.db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
