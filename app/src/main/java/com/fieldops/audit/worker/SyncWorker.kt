package com.fieldops.audit.worker

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.fieldops.audit.data.database.AuditDatabase

class SyncWorker(appContext: Context, workerParams: WorkerParameters) :
    CoroutineWorker(appContext, workerParams) {

    override suspend fun doWork(): Result {
        val db = AuditDatabase.getDatabase(applicationContext)
        val unsynced = db.inventoryDao().getUnsyncedItems()

        if (unsynced.isEmpty()) {
            return Result.success()
        }

        return try {
            // Simulated cloud sync dispatch
            val syncedIds = unsynced.map { it.id }
            db.inventoryDao().markAsSynced(syncedIds)
            Result.success()
        } catch (e: Exception) {
            Result.retry()
        }
    }
}
