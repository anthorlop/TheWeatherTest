package es.unidadeditorial.gazzanet.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ue.projects.framework.uecmsparser.datatypes.CMSItem;
import com.ue.projects.framework.uecmsparser.datatypes.NoticiaItem;
import com.ue.projects.framework.uecmsparser.datatypes.multimedia.Multimedia;
import com.ue.projects.framework.uecmsparser.datatypes.multimedia.MultimediaImagen;
import com.ue.projects.framework.uecmsparser.datatypes.multimedia.MultimediaVideo;
import com.ue.projects.framework.uecoreeditorial.datatype.master.UEMaster;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;

import static com.ue.projects.framework.uecmsparser.datatypes.CMSItem.DEFAULT_IN_DATE_FORMAT;
import static es.unidadeditorial.gazzanet.BuildConfig.HAS_FIGLI;

public class PersistentData {

    public static final String DESTACADAS_LIST = "DestacadasList";
    public static final String PORTADA_NEWS_LIST = "PortadaNewsList";
    public static final String PORTADA_VIDEO_LIST = "PortadaVideoList";

    public static void saveParam(Context c, String key, Object value) {
        SharedPreferences preferences = c.getSharedPreferences("gazzanet", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        if (value instanceof String) {
            editor.putString(key, (String) value);
        } else if (value instanceof Integer) {
            editor.putString(key, String.valueOf(value));
        }

        editor.apply();
    }

    public static void removeParam(Context c, String key) {
        SharedPreferences preferences = c.getSharedPreferences("gazzanet", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        editor.remove(key);

        editor.apply();
    }

    public static String getParam(Context c, String key) {
        SharedPreferences preferences = c.getSharedPreferences("gazzanet", Context.MODE_PRIVATE);
        return preferences.getString(key, null);
    }

    public static void saveAffiliatiList(Context c, List<Affiliati> list) {
        SharedPreferences appSharedPrefs = PreferenceManager.getDefaultSharedPreferences(c);
        SharedPreferences.Editor prefsEditor = appSharedPrefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        prefsEditor.putString("AffliliatiList", json);
        prefsEditor.apply();
    }

    public static List<Affiliati> getAffiliatiList(Context c) {

        if (!HAS_FIGLI) {
            return null;
        }

        SharedPreferences appSharedPrefs = PreferenceManager.getDefaultSharedPreferences(c);
        Gson gson = new Gson();
        Type type = new TypeToken<List<Affiliati>>(){}.getType();
        String json = appSharedPrefs.getString("AffliliatiList", "");

        return gson.fromJson(json, type);
    }

    public static void saveSquadraList(Context c, List<Squadra> list) {
        SharedPreferences appSharedPrefs = PreferenceManager.getDefaultSharedPreferences(c);
        SharedPreferences.Editor prefsEditor = appSharedPrefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        prefsEditor.putString("SquadraList", json);
        prefsEditor.apply();
    }

    public static List<Squadra> getSquadraList(Context c) {

        if (!HAS_FIGLI) {
            return null;
        }

        SharedPreferences appSharedPrefs = PreferenceManager.getDefaultSharedPreferences(c);
        Gson gson = new Gson();
        Type type = new TypeToken<List<Squadra>>(){}.getType();
        String json = appSharedPrefs.getString("SquadraList", "");

        return gson.fromJson(json, type);
    }

    public static void saveLiteCMSList(Context c, List<NoticiaItem> list, String key) {
        if (list == null || list.isEmpty()) {
            return;
        }

        List<NoticiaItemLite> liteList = new ArrayList<>();

        NoticiaItemLite lite;
        for (NoticiaItem item : list) {
            lite = new NoticiaItemLite();
            lite.setId(item.getId());
            lite.setTitulo(item.getTitulo());
            lite.setType(item.getType());
            lite.setCintillo(item.getCintillo());
            lite.setEntradilla(item.getEntradilla());
            lite.setAntetitulo(item.getAntetitulo());
            lite.setPublishedAt(item.getPublishedAtTimestamp());
            lite.setFirstPublishedAt(item.getFirstPublishedAtTimestamp());
            lite.setSectionId(item.getSectionId());
            lite.setLinkRedireccion(item.getLinkRedireccion());
            lite.setSectionName(item.getSectionName());

            if (item.getThumbnail() != null && item.getThumbnail() instanceof MultimediaImagen) {
                lite.setImage(((MultimediaImagen) item.getThumbnail()).getUrl());
                lite.setHasIcon(item.getThumbnail().getHasIcon());
                lite.setThumbnail("1");
            } else if (item.getThumbnail() != null && item.getThumbnail() instanceof MultimediaVideo) {
                if (UEMaster.getUeVideosInteractor() != null) {
                    int width = c.getResources().getDimensionPixelSize(com.ue.projects.framework.uecoreeditorial.R.dimen.noticias_list_image_width);
                    int height = c.getResources().getDimensionPixelSize(com.ue.projects.framework.uecoreeditorial.R.dimen.noticias_list_image_height);
                    String url = UEMaster.getUeVideosInteractor().generateImagenURLPXKaltura(item.getThumbnail().getId(), width, height, String.valueOf(item.getPublishedAtTimestamp()));
                    lite.setImage(url);
                }
                lite.setHasVideo(true);
                lite.setHasIcon(item.getThumbnail().getHasIcon());
                lite.setThumbnail(item.getThumbnail().getId());
            }

            liteList.add(lite);

        }

        SharedPreferences appSharedPrefs = PreferenceManager.getDefaultSharedPreferences(c);
        SharedPreferences.Editor prefsEditor = appSharedPrefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(liteList);
        prefsEditor.putString(key, json);
        prefsEditor.apply();
    }

    public static List<CMSItem> getLiteCMSList(Context c, String key) {

        SharedPreferences appSharedPrefs = PreferenceManager.getDefaultSharedPreferences(c);
        Gson gson = new Gson();
        Type type = new TypeToken<List<NoticiaItemLite>>(){}.getType();
        String json = appSharedPrefs.getString(key, "");

        List<NoticiaItemLite> liteList = gson.fromJson(json, type);

        List<CMSItem> items = new ArrayList<>();

        NoticiaItem item;
        for (NoticiaItemLite lite : liteList) {
            item = new NoticiaItem();
            item.setId(lite.getId());
            item.setTitulo(lite.getTitulo());
            item.setType(lite.getType());
            item.setCintillo(lite.getCintillo());
            item.setEntradilla(lite.getEntradilla());
            item.setAntetitulo(lite.getAntetitulo());
            SimpleDateFormat sdfOutput = new SimpleDateFormat(DEFAULT_IN_DATE_FORMAT, Locale.ENGLISH);
            Date date = new Date();
            date.setTime(lite.getPublishedAt());
            item.setPublishedAt(sdfOutput.format(date));
            Date dateFirst = new Date();
            dateFirst.setTime(lite.getFirstPublishedAt());
            item.setFirstPublishedAt(sdfOutput.format(dateFirst));
            item.setSectionId(lite.getSectionId());
            item.setSectionName(lite.getSectionName());
            item.setThumbnail(lite.getThumbnail());
            item.setLinkRedireccion(lite.getLinkRedireccion());
            item.setLink(lite.getLinkRedireccion());
            item.setLiteVersion(true);

            if (lite.getThumbnail() != null) {
                LinkedHashMap<String, Multimedia> multimedias = new LinkedHashMap<>();
                if (lite.hasVideo) {
                    MultimediaVideo m = new MultimediaVideo();
                    m.setId(lite.getThumbnail());
                    m.setHasIcon(lite.getHasIcon());
                    multimedias.put(lite.getThumbnail(), m);
                } else {
                    MultimediaImagen m = new MultimediaImagen();
                    m.setUrl(lite.getImage());
                    m.setHasIcon(lite.getHasIcon());
                    multimedias.put("1", m);
                }
                item.setMultimedia(multimedias);
            }

            items.add(item);

        }

        return items;
    }

}
