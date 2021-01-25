package com.jzz.tool;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.dockerjava.api.model.Image;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author:jzz
 * @date:2021/1/23
 */
@Data
public class ImageVo {

    @JsonProperty("Created")
    private Long created;
    @JsonProperty("Id")
    private String id;
    @JsonProperty("ParentId")
    private String parentId;
    @JsonProperty("RepoTag")
    private String repoTag;
    @JsonProperty("RepoDigests")
    private String[] repoDigests;
    @JsonProperty("Size")
    private Long size;
    @JsonProperty("VirtualSize")
    private Long virtualSize;
    @JsonProperty("SharedSize")
    private Long sharedSize;
    @JsonProperty("Labels")
    public Map<String, String> labels;
    @JsonProperty("Containers")
    private Integer containers;


    public ImageVo (Image image, Integer index) {
        this.created = image.getCreated();
        this.id = image.getId();
        this.parentId = image.getParentId();
        this.repoTag = image.getRepoTags()[index];
        this.repoDigests = image.getRepoDigests();
        this.size = image.getSize();
        this.virtualSize = image.getVirtualSize();
        this.sharedSize = image.getSharedSize();
        this.labels = image.getLabels();
        this.containers = image.getContainers();
    }

    public static List<ImageVo> asImages (List<Image> list) {
        ArrayList<ImageVo> imageVos = new ArrayList<>();
        for (Image image : list) {
            List<ImageVo> images = asImage(image);
            imageVos.addAll(images);
        }
        return imageVos;
    }

    public static List<ImageVo> asImage (Image image) {
        ArrayList<ImageVo> imageVos = new ArrayList<>();
        String[] repoTags = image.getRepoTags();
        for (int i = 0; i < repoTags.length; i ++) {
            ImageVo imageVo = new ImageVo(image, i);
            imageVos.add(imageVo);
        }
        return imageVos;
    }


}