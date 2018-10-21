/*
 * Copyright 2017, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.softandino.android.sobreruedas.db.ConfiguracionBD;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.content.Context;

import com.softandino.android.sobreruedas.db.converter.DateConverter;
import com.softandino.android.sobreruedas.db.dao.RodadaDao;
import com.softandino.android.sobreruedas.db.entity.Rodada;

import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;

@Database(entities = {Rodada.class}, version = 1)
@TypeConverters(DateConverter.class)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase sInstance;

    @VisibleForTesting
    public static final String DATABASE_NAME = "SOBRE_RUEDAS";

    public abstract RodadaDao rodadaDao();

    public static AppDatabase getInstance(final Context context) {
        if (sInstance == null) {
            synchronized (AppDatabase.class) {
                if (sInstance == null) {
                    sInstance = Room.databaseBuilder(context, AppDatabase.class, DATABASE_NAME).addCallback(new Callback() {
                        @Override
                        public void onCreate(@NonNull SupportSQLiteDatabase db) {
                            AppDatabase database = AppDatabase.getInstance(context);
                            database.beginTransaction();
                            database.rodadaDao().insert(new Rodada(1, "Bendicion Motera", "Rodada por buga todo el dia", "Ricardo Enriquez", "40.000", "1", "FM"));
                            database.rodadaDao().insert(new Rodada(2, "Bendicion Motera2", "Rodada por buga todo el dia2", "Ricardo Enriquez2", "40.000", "1", "FM"));
                            database.endTransaction();
                        }
                    }).build();
                }
            }
        }


        return sInstance;
    }
}
