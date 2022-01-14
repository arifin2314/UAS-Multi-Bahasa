package com.example.arifin;

import android.content.Context;
import com.example.arifin.model.wisata;
import com.example.arifin.model.air_terjun;
import com.example.arifin.model.pantai;
import com.example.arifin.model.pengunungan;
import com.example.arifin.model.religi;

import java.util.ArrayList;
import java.util.List;

public class galery {
    private static List<wisata> wisatas = new ArrayList<>();

    private static List<air_terjun> initDataair_terjun(Context ctx) {
        List<air_terjun> air_terjuns = new ArrayList<>();
        air_terjuns.add(new air_terjun(ctx.getString(R.string.nama_airterjun) ,ctx.getString(R.string.lokasi),ctx.getString(R.string.airterjun),R.drawable.image5));
        air_terjuns.add(new air_terjun(ctx.getString(R.string.nama),ctx.getString(R.string.santong),ctx.getString(R.string.desc2air), R.drawable.t2));
        air_terjuns.add(new air_terjun(ctx.getString(R.string.nama3), ctx.getString(R.string.lokasi3), ctx.getString(R.string.desc3),R.drawable.t3));
        air_terjuns.add(new air_terjun(ctx.getString(R.string.nama4), ctx.getString(R.string.lokasi4), ctx.getString(R.string.desc4), R.drawable.t4));
        air_terjuns.add(new air_terjun(ctx.getString(R.string.nama5), ctx.getString(R.string.lok5), ctx.getString(R.string.desc5), R.drawable.t5));
        return air_terjuns;
    }

    private static List<pantai> initDatapantai(Context ctx) {
        List<pantai> pantais = new ArrayList<>();
        pantais.add(new pantai(ctx.getString(R.string.nama6), ctx.getString(R.string.lok6),
                ctx.getString(R.string.desc6), R.drawable.pan));
        pantais.add(new pantai(ctx.getString(R.string.nama7), ctx.getString(R.string.loc7),
                ctx.getString(R.string.desc7), R.drawable.pan2));
        pantais.add(new pantai(ctx.getString(R.string.name8), ctx.getString(R.string.loc8),
                ctx.getString(R.string.desc8), R.drawable.pan3));
        pantais.add(new pantai(ctx.getString(R.string.name9), ctx.getString(R.string.loc9),
                ctx.getString(R.string.desc9), R.drawable.pan4));
        pantais.add(new pantai(ctx.getString(R.string.name10),ctx.getString(R.string.loc10),
                ctx.getString(R.string.desc10), R.drawable.pan5));

        return pantais;
    }
    private static List<pengunungan> initDatapengunungan(Context ctx) {
        List<pengunungan> pengunungans = new ArrayList<>();
        pengunungans.add(new pengunungan(ctx.getString(R.string.name11), ctx.getString(R.string.loc11),
                ctx.getString(R.string.desc11), R.drawable.g1));
        pengunungans.add(new pengunungan(ctx.getString(R.string.name1_2), ctx.getString(R.string.loc12),
                ctx.getString(R.string.desc12), R.drawable.g2));
        pengunungans.add(new pengunungan(ctx.getString(R.string.name13), ctx.getString(R.string.loc13),
                ctx.getString(R.string.desc13), R.drawable.g3));
        pengunungans.add(new pengunungan(ctx.getString(R.string.name14), ctx.getString(R.string.loc14),
                ctx.getString(R.string.desc14), R.drawable.g4));
        pengunungans.add(new pengunungan(ctx.getString(R.string.name15), ctx.getString(R.string.loc15),
                ctx.getString(R.string.desc15), R.drawable.g5));

        return pengunungans;
    }
    private static List<religi> initData(Context ctx) {
        List<religi> religis = new ArrayList<>();
        religis.add(new religi(ctx.getString(R.string.nmae16), ctx.getString(R.string.loc16),
                ctx.getString(R.string.desc16),R.drawable.re));
        religis.add(new religi(ctx.getString(R.string.name17), ctx.getString(R.string.loc17),
                ctx.getString(R.string.desc17), R.drawable.re2));
        religis.add(new religi(ctx.getString(R.string.name18), ctx.getString(R.string.loc18),
                ctx.getString(R.string.desc18), R.drawable.re3));
        religis.add(new religi(ctx.getString(R.string.name19), ctx.getString(R.string.loc19),
                ctx.getString(R.string.desc19), R.drawable.re4));
        religis.add(new religi(ctx.getString(R.string.name20), ctx.getString(R.string.loc20),
                ctx.getString(R.string.desc20), R.drawable.re5));

        return religis;
    }

    private static void initAllwisatas(Context ctx) {
        wisatas.addAll(initData(ctx));
        wisatas.addAll(initDataair_terjun(ctx));
        wisatas.addAll(initDatapantai(ctx));
        wisatas.addAll(initDatapengunungan(ctx));
    }

    public static List<wisata> getAllwisata(Context ctx) {
        if (wisatas.size() == 0) {
            initAllwisatas(ctx);
        }
        return  wisatas;
    }

    public static List<wisata> getWisatasByTipe(Context ctx, String jenis) {
        List<wisata> wisatasByType = new ArrayList<>();
        if (wisatas.size() == 0) {
            initAllwisatas(ctx);
        }
        for (wisata h : wisatas) {
            if (h.getJenis().equals(jenis)) {
                wisatasByType.add(h);
            }
        }
        return wisatasByType;
    }

}
