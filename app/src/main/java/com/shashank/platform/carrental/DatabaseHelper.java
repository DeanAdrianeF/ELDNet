package com.shashank.platform.carrental;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {

    String Rental_Table = "Rental_Table";
    String Rental_FullName = "Rental_FullName";
    String Rental_UserName = "Rental_UserName";
    String Rental_Email = "Rental_Email";
    String Rental_Password = "Rental_Password";
    String Rental_ConfirmPassword = "Rental_ConfirmPassword";
    String Rental_PhoneNumber = "Rental_PhoneNumber";
    String Rental_DriversLicense = "Rental_DriversLicense";

    public DatabaseHelper(@Nullable Context context) {
        super(context, "RentalBuddy.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String createTable = "CREATE TABLE " + Rental_Table + "(" + Rental_DriversLicense + " TEXT PRIMARY KEY, " + Rental_FullName + " TEXT, " + Rental_UserName +
                " TEXT, " + Rental_Email + " TEXT, " + Rental_Password + " TEXT, " + Rental_ConfirmPassword + " TEXT, " + Rental_PhoneNumber + " TEXT) ";
        Log.d("onCreate", createTable);
        sqLiteDatabase.execSQL(createTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean addBuddy(RentalBuddyModel rentalBuddyModel)
    {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(Rental_DriversLicense, rentalBuddyModel.getDriversLicense());
        cv.put(Rental_Email, rentalBuddyModel.getEmail());
        cv.put(Rental_Password, rentalBuddyModel.getPassword());
        cv.put(Rental_ConfirmPassword, rentalBuddyModel.getConfirmPassword());
        cv.put(Rental_FullName, rentalBuddyModel.getFullName());
        cv.put(Rental_PhoneNumber, rentalBuddyModel.getPhoneNumber());


        long insertResult = db.insert(Rental_Table, null, cv);
        boolean isInsertSuccessful = insertResult > 0 ? true : false;

        return isInsertSuccessful;

    }
}
