package br.com.charleseduardo.apilog.api.exceptionhandler;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;
import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Problem {

    private Integer status;
    private LocalDateTime dateHour;
    private String title;
    private List<Fields> fields;

    public static class Fields{

        private String name;
        private String message;

        public Fields(String name, String message) {
            this.name = name;
            this.message = message;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setDateHour(LocalDateTime dateHour) {
        this.dateHour = dateHour;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setFields(List<Fields> fields) {
        this.fields = fields;
    }

    public Integer getStatus() {
        return status;
    }

    public LocalDateTime getDateHour() {
        return dateHour;
    }

    public String getTitle() {
        return title;
    }

    public List<Fields> getFields() {
        return fields;
    }
}
