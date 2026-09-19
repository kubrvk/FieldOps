package com.fieldops.audit

import android.app.Application
import com.fieldops.audit.data.database.AuditDatabase

class FieldOpsApp : Application() {
    val database by lazy { AuditDatabase.getDatabase(this) }
}
