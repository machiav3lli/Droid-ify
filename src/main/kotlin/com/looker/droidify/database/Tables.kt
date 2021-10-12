package com.looker.droidify.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.looker.droidify.entity.Product
import com.looker.droidify.entity.ProductItem
import com.looker.droidify.entity.Repository

@Entity
class Repository {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "_id")
    var id: Long = 0

    var enabled = 0
    var deleted = 0

    @ColumnInfo(typeAffinity = ColumnInfo.BLOB)
    var data: Repository? = null
}

@Entity(primaryKeys = ["repository_id", "package_name"])
class Product {
    var repository_id: Long = 0
    var package_name = ""

    var name = ""
    var summary = ""
    var description = ""
    var added = 0
    var updated = 0
    var version_code = 0
    var signatures = ""
    var compatible = 0

    @ColumnInfo(typeAffinity = ColumnInfo.BLOB)
    var data: Product? = null

    @ColumnInfo(typeAffinity = ColumnInfo.BLOB)
    var data_item: ProductItem? = null
}

@Entity(primaryKeys = ["repository_id", "package_name", "name"])
class Category {
    var repository_id: Long = 0
    var package_name = ""
    var name = ""
}

@Entity
class Installed {
    @PrimaryKey
    var package_name = ""

    var version = ""
    var version_code = 0
    var signatures = ""
}

@Entity
class Lock {
    @PrimaryKey
    var package_name = ""

    var version_code = 0
}