
package beans;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Card {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("closed")
    @Expose
    private Boolean closed;
    @SerializedName("dueComplete")
    @Expose
    private Boolean dueComplete;
    @SerializedName("dateLastActivity")
    @Expose
    private String dateLastActivity;
    @SerializedName("desc")
    @Expose
    private String desc;
    @SerializedName("descData")
    @Expose
    private Object descData;
    @SerializedName("due")
    @Expose
    private Object due;
    @SerializedName("email")
    @Expose
    private Object email;
    @SerializedName("idBoard")
    @Expose
    private String idBoard;
    @SerializedName("idList")
    @Expose
    private String idList;
    @SerializedName("idShort")
    @Expose
    private Integer idShort;
    @SerializedName("idAttachmentCover")
    @Expose
    private String idAttachmentCover;
    @SerializedName("labels")
    @Expose
    private List<Label> labels = new ArrayList<Label>();
    @SerializedName("idLabels")
    @Expose
    private List<String> idLabels = new ArrayList<String>();
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("pos")
    @Expose
    private Integer pos;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getClosed() {
        return closed;
    }

    public void setClosed(Boolean closed) {
        this.closed = closed;
    }

    public Boolean getDueComplete() {
        return dueComplete;
    }

    public void setDueComplete(Boolean dueComplete) {
        this.dueComplete = dueComplete;
    }

    public String getDateLastActivity() {
        return dateLastActivity;
    }

    public void setDateLastActivity(String dateLastActivity) {
        this.dateLastActivity = dateLastActivity;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Object getDescData() {
        return descData;
    }

    public void setDescData(Object descData) {
        this.descData = descData;
    }

    public Object getDue() {
        return due;
    }

    public void setDue(Object due) {
        this.due = due;
    }

    public Object getEmail() {
        return email;
    }

    public void setEmail(Object email) {
        this.email = email;
    }

    public String getIdBoard() {
        return idBoard;
    }

    public void setIdBoard(String idBoard) {
        this.idBoard = idBoard;
    }

    public String getIdList() {
        return idList;
    }

    public void setIdList(String idList) {
        this.idList = idList;
    }

    public Integer getIdShort() {
        return idShort;
    }

    public void setIdShort(Integer idShort) {
        this.idShort = idShort;
    }

    public String getIdAttachmentCover() {
        return idAttachmentCover;
    }

    public void setIdAttachmentCover(String idAttachmentCover) {
        this.idAttachmentCover = idAttachmentCover;
    }

    public List<Label> getLabels() {
        return labels;
    }

    public void setLabels(List<Label> labels) {
        this.labels = labels;
    }

    public List<String> getIdLabels() {
        return idLabels;
    }

    public void setIdLabels(List<String> idLabels) {
        this.idLabels = idLabels;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPos() {
        return pos;
    }

    public void setPos(Integer pos) {
        this.pos = pos;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Card.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("closed");
        sb.append('=');
        sb.append(((this.closed == null)?"<null>":this.closed));
        sb.append(',');
        sb.append("dueComplete");
        sb.append('=');
        sb.append(((this.dueComplete == null)?"<null>":this.dueComplete));
        sb.append(',');
        sb.append("dateLastActivity");
        sb.append('=');
        sb.append(((this.dateLastActivity == null)?"<null>":this.dateLastActivity));
        sb.append(',');
        sb.append("desc");
        sb.append('=');
        sb.append(((this.desc == null)?"<null>":this.desc));
        sb.append(',');
        sb.append("descData");
        sb.append('=');
        sb.append(((this.descData == null)?"<null>":this.descData));
        sb.append(',');
        sb.append("due");
        sb.append('=');
        sb.append(((this.due == null)?"<null>":this.due));
        sb.append(',');
        sb.append("email");
        sb.append('=');
        sb.append(((this.email == null)?"<null>":this.email));
        sb.append(',');
        sb.append("idBoard");
        sb.append('=');
        sb.append(((this.idBoard == null)?"<null>":this.idBoard));
        sb.append(',');
        sb.append("idList");
        sb.append('=');
        sb.append(((this.idList == null)?"<null>":this.idList));
        sb.append(',');
        sb.append("idShort");
        sb.append('=');
        sb.append(((this.idShort == null)?"<null>":this.idShort));
        sb.append(',');
        sb.append("idAttachmentCover");
        sb.append('=');
        sb.append(((this.idAttachmentCover == null)?"<null>":this.idAttachmentCover));
        sb.append(',');
        sb.append("labels");
        sb.append('=');
        sb.append(((this.labels == null)?"<null>":this.labels));
        sb.append(',');
        sb.append("idLabels");
        sb.append('=');
        sb.append(((this.idLabels == null)?"<null>":this.idLabels));
        sb.append(',');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null)?"<null>":this.name));
        sb.append(',');
        sb.append("pos");
        sb.append('=');
        sb.append(((this.pos == null)?"<null>":this.pos));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.descData == null)? 0 :this.descData.hashCode()));
        result = ((result* 31)+((this.idBoard == null)? 0 :this.idBoard.hashCode()));
        result = ((result* 31)+((this.idLabels == null)? 0 :this.idLabels.hashCode()));
        result = ((result* 31)+((this.dueComplete == null)? 0 :this.dueComplete.hashCode()));
        result = ((result* 31)+((this.dateLastActivity == null)? 0 :this.dateLastActivity.hashCode()));
        result = ((result* 31)+((this.idList == null)? 0 :this.idList.hashCode()));
        result = ((result* 31)+((this.labels == null)? 0 :this.labels.hashCode()));
        result = ((result* 31)+((this.idShort == null)? 0 :this.idShort.hashCode()));
        result = ((result* 31)+((this.due == null)? 0 :this.due.hashCode()));
        result = ((result* 31)+((this.pos == null)? 0 :this.pos.hashCode()));
        result = ((result* 31)+((this.idAttachmentCover == null)? 0 :this.idAttachmentCover.hashCode()));
        result = ((result* 31)+((this.name == null)? 0 :this.name.hashCode()));
        result = ((result* 31)+((this.closed == null)? 0 :this.closed.hashCode()));
        result = ((result* 31)+((this.id == null)? 0 :this.id.hashCode()));
        result = ((result* 31)+((this.email == null)? 0 :this.email.hashCode()));
        result = ((result* 31)+((this.desc == null)? 0 :this.desc.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Card) == false) {
            return false;
        }
        Card rhs = ((Card) other);
        return (((((((((((((((((this.descData == rhs.descData)||((this.descData!= null)&&this.descData.equals(rhs.descData)))&&((this.idBoard == rhs.idBoard)||((this.idBoard!= null)&&this.idBoard.equals(rhs.idBoard))))&&((this.idLabels == rhs.idLabels)||((this.idLabels!= null)&&this.idLabels.equals(rhs.idLabels))))&&((this.dueComplete == rhs.dueComplete)||((this.dueComplete!= null)&&this.dueComplete.equals(rhs.dueComplete))))&&((this.dateLastActivity == rhs.dateLastActivity)||((this.dateLastActivity!= null)&&this.dateLastActivity.equals(rhs.dateLastActivity))))&&((this.idList == rhs.idList)||((this.idList!= null)&&this.idList.equals(rhs.idList))))&&((this.labels == rhs.labels)||((this.labels!= null)&&this.labels.equals(rhs.labels))))&&((this.idShort == rhs.idShort)||((this.idShort!= null)&&this.idShort.equals(rhs.idShort))))&&((this.due == rhs.due)||((this.due!= null)&&this.due.equals(rhs.due))))&&((this.pos == rhs.pos)||((this.pos!= null)&&this.pos.equals(rhs.pos))))&&((this.idAttachmentCover == rhs.idAttachmentCover)||((this.idAttachmentCover!= null)&&this.idAttachmentCover.equals(rhs.idAttachmentCover))))&&((this.name == rhs.name)||((this.name!= null)&&this.name.equals(rhs.name))))&&((this.closed == rhs.closed)||((this.closed!= null)&&this.closed.equals(rhs.closed))))&&((this.id == rhs.id)||((this.id!= null)&&this.id.equals(rhs.id))))&&((this.email == rhs.email)||((this.email!= null)&&this.email.equals(rhs.email))))&&((this.desc == rhs.desc)||((this.desc!= null)&&this.desc.equals(rhs.desc))));
    }

}
