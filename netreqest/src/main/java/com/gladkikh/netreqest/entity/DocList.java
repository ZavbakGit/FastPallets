
package com.gladkikh.netreqest.entity;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DocList {

    @SerializedName("doc_type")
    @Expose
    private String docType;
    @SerializedName("doc_guid")
    @Expose
    private String docGuid;
    @SerializedName("doc_number")
    @Expose
    private String docNumber;
    @SerializedName("doc_datetime")
    @Expose
    private String docDatetime;
    @SerializedName("doc_pal_list")
    @Expose
    private String docPalList;
    @SerializedName("doc_state")
    @Expose
    private String docState;
    @SerializedName("doc_pal_list_accounting_count")
    @Expose
    private String docPalListAccountingCount;
    @SerializedName("doc_pal_list_accounting")
    @Expose
    private List<DocPalListAccounting> docPalListAccounting = null;

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public String getDocGuid() {
        return docGuid;
    }

    public void setDocGuid(String docGuid) {
        this.docGuid = docGuid;
    }

    public String getDocNumber() {
        return docNumber;
    }

    public void setDocNumber(String docNumber) {
        this.docNumber = docNumber;
    }

    public String getDocDatetime() {
        return docDatetime;
    }

    public void setDocDatetime(String docDatetime) {
        this.docDatetime = docDatetime;
    }

    public String getDocPalList() {
        return docPalList;
    }

    public void setDocPalList(String docPalList) {
        this.docPalList = docPalList;
    }

    public String getDocState() {
        return docState;
    }

    public void setDocState(String docState) {
        this.docState = docState;
    }

    public String getDocPalListAccountingCount() {
        return docPalListAccountingCount;
    }

    public void setDocPalListAccountingCount(String docPalListAccountingCount) {
        this.docPalListAccountingCount = docPalListAccountingCount;
    }

    public List<DocPalListAccounting> getDocPalListAccounting() {
        return docPalListAccounting;
    }

    public void setDocPalListAccounting(List<DocPalListAccounting> docPalListAccounting) {
        this.docPalListAccounting = docPalListAccounting;
    }

}
