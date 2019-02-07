
package com.gladkikh.netreqest.entity;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class DocPalListAccounting {

    @SerializedName("palet_code")
    @Expose
    private String paletCode;
    @SerializedName("palet_guid")
    @Expose
    private String paletGuid;
    @SerializedName("palet_tovar")
    @Expose
    private String paletTovar;
    @SerializedName("palet_state")
    @Expose
    private String paletState;
    @SerializedName("palet_store")
    @Expose
    private String paletStore;
    @SerializedName("palet_weight")
    @Expose
    private String paletWeight;
    @SerializedName("palet_places_count")
    @Expose
    private String paletPlacesCount;
    @SerializedName("palet_places")
    @Expose
    private List<Integer> paletPlaces = null;

    public String getPaletCode() {
        return paletCode;
    }

    public void setPaletCode(String paletCode) {
        this.paletCode = paletCode;
    }

    public String getPaletGuid() {
        return paletGuid;
    }

    public void setPaletGuid(String paletGuid) {
        this.paletGuid = paletGuid;
    }

    public String getPaletTovar() {
        return paletTovar;
    }

    public void setPaletTovar(String paletTovar) {
        this.paletTovar = paletTovar;
    }

    public String getPaletState() {
        return paletState;
    }

    public void setPaletState(String paletState) {
        this.paletState = paletState;
    }

    public String getPaletStore() {
        return paletStore;
    }

    public void setPaletStore(String paletStore) {
        this.paletStore = paletStore;
    }

    public String getPaletWeight() {
        return paletWeight;
    }

    public void setPaletWeight(String paletWeight) {
        this.paletWeight = paletWeight;
    }

    public String getPaletPlacesCount() {
        return paletPlacesCount;
    }

    public void setPaletPlacesCount(String paletPlacesCount) {
        this.paletPlacesCount = paletPlacesCount;
    }

    public List<Integer> getPaletPlaces() {
        return paletPlaces;
    }

    public void setPaletPlaces(List<Integer> paletPlaces) {
        this.paletPlaces = paletPlaces;
    }

}
