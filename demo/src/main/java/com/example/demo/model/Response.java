package com.example.demo.model;

public class Response {
    private String freq_word;
    private double avg_paragraph_size;
    private  double avg_paragraph_processing_time;
    private double total_processing_time;

    public Response() {
    }

    public Response(String freq_word, double avg_paragraph_size, double avg_paragraph_processing_time, double total_processing_time) {
        this.freq_word = freq_word;
        this.avg_paragraph_size = avg_paragraph_size;
        this.avg_paragraph_processing_time = avg_paragraph_processing_time;
        this.total_processing_time = total_processing_time;
    }

    public String getFreq_word() {
        return freq_word;
    }

    public void setFreq_word(String freq_word) {
        this.freq_word = freq_word;
    }

    public double getAvg_paragraph_size() {
        return avg_paragraph_size;
    }

    public void setAvg_paragraph_size(double avg_paragraph_size) {
        this.avg_paragraph_size = avg_paragraph_size;
    }

    public double getAvg_paragraph_processing_time() {
        return avg_paragraph_processing_time;
    }

    public void setAvg_paragraph_processing_time(double avg_paragraph_processing_time) {
        this.avg_paragraph_processing_time = avg_paragraph_processing_time;
    }

    public double getTotal_processing_time() {
        return total_processing_time;
    }

    public void setTotal_processing_time(double total_processing_time) {
        this.total_processing_time = total_processing_time;
    }

    @Override
    public String toString() {
        return "Response{" +
                "freq_word='" + freq_word + '\'' +
                ", avg_paragraph_size=" + avg_paragraph_size +
                ", avg_paragraph_processing_time=" + avg_paragraph_processing_time +
                ", total_processing_time=" + total_processing_time +
                '}';
    }
}
