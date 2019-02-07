
package com.gladkikh.netreqest.entity;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RsGetDoc {

    @SerializedName("docs_list_count")
    @Expose
    private String docsListCount;
    @SerializedName("doc_list")
    @Expose
    private List<DocList> docList = null;

    public String getDocsListCount() {
        return docsListCount;
    }

    public void setDocsListCount(String docsListCount) {
        this.docsListCount = docsListCount;
    }

    public List<DocList> getDocList() {
        return docList;
    }

    public void setDocList(List<DocList> docList) {
        this.docList = docList;
    }

}
