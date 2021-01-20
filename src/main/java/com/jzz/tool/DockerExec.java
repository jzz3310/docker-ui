package com.jzz.tool;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.command.*;
import com.github.dockerjava.api.exception.DockerException;
import com.github.dockerjava.api.model.*;
import lombok.Data;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author:jzz
 * @date:2021/1/12
 */
@Data
public class DockerExec implements DockerClient {
    private DockerClient dockerClient;

    public boolean isExistTag(String imageName) {
        List<Image> collect = listImagesCmd().exec().stream().filter(image -> Arrays.asList(image.getRepoTags()).contains(imageName)).collect(Collectors.toList());
        if (null != collect && collect.size() > 0) {
            return true;
        }
        return false;
    }



    //---------------------------------------------------overried-----------------------------------------------------------

    @Override
    public AuthConfig authConfig() throws DockerException {
        return dockerClient.authConfig();
    }

    @Override
    public AuthCmd authCmd() {
        return dockerClient.authCmd();
    }

    @Override
    public InfoCmd infoCmd() {
        return dockerClient.infoCmd();
    }

    @Override
    public PingCmd pingCmd() {
        return dockerClient.pingCmd();
    }

    @Override
    public VersionCmd versionCmd() {
        return dockerClient.versionCmd();
    }

    @Override
    public PullImageCmd pullImageCmd(String s) {
        return dockerClient.pullImageCmd(s);
    }

    @Override
    public PushImageCmd pushImageCmd(String s) {
        return dockerClient.pushImageCmd(s);
    }

    @Override
    public PushImageCmd pushImageCmd(Identifier identifier) {
        return dockerClient.pushImageCmd(identifier);
    }

    @Override
    public CreateImageCmd createImageCmd(String s, InputStream inputStream) {
        return dockerClient.createImageCmd(s,inputStream);
    }

    @Override
    public LoadImageCmd loadImageCmd(InputStream inputStream) {
        return dockerClient.loadImageCmd(inputStream);
    }

    @Override
    public SearchImagesCmd searchImagesCmd(String s) {
        return dockerClient.searchImagesCmd(s);
    }

    @Override
    public RemoveImageCmd removeImageCmd(String s) {
        return dockerClient.removeImageCmd(s);
    }

    @Override
    public ListImagesCmd listImagesCmd() {
        return dockerClient.listImagesCmd();
    }

    @Override
    public InspectImageCmd inspectImageCmd(String s) {
        return dockerClient.inspectImageCmd(s);
    }

    @Override
    public SaveImageCmd saveImageCmd(String s) {
        return dockerClient.saveImageCmd(s);
    }

    @Override
    public SaveImagesCmd saveImagesCmd() {
        return dockerClient.saveImagesCmd();
    }

    @Override
    public ListContainersCmd listContainersCmd() {
        return dockerClient.listContainersCmd();
    }

    @Override
    public CreateContainerCmd createContainerCmd(String s) {
        return dockerClient.createContainerCmd(s);
    }

    @Override
    public StartContainerCmd startContainerCmd(String s) {
        return dockerClient.startContainerCmd(s);
    }

    @Override
    public ExecCreateCmd execCreateCmd(String s) {
        return dockerClient.execCreateCmd(s);
    }

    @Override
    public ResizeExecCmd resizeExecCmd(String s) {
        return dockerClient.resizeExecCmd(s);
    }

    @Override
    public InspectContainerCmd inspectContainerCmd(String s) {
        return dockerClient.inspectContainerCmd(s);
    }

    @Override
    public RemoveContainerCmd removeContainerCmd(String s) {
        return dockerClient.removeContainerCmd(s);
    }

    @Override
    public WaitContainerCmd waitContainerCmd(String s) {
        return dockerClient.waitContainerCmd(s);
    }

    @Override
    public AttachContainerCmd attachContainerCmd(String s) {
        return dockerClient.attachContainerCmd(s);
    }

    @Override
    public ExecStartCmd execStartCmd(String s) {
        return dockerClient.execStartCmd(s);
    }

    @Override
    public InspectExecCmd inspectExecCmd(String s) {
        return dockerClient.inspectExecCmd(s);
    }

    @Override
    public LogContainerCmd logContainerCmd(String s) {
        return dockerClient.logContainerCmd(s);
    }

    @Override
    public CopyArchiveFromContainerCmd copyArchiveFromContainerCmd(String s, String s1) {
        return dockerClient.copyArchiveFromContainerCmd(s,s1);
    }

    @Deprecated
    @Override
    public CopyFileFromContainerCmd copyFileFromContainerCmd(String s, String s1) {
        return dockerClient.copyFileFromContainerCmd(s,s1);
    }

    @Override
    public CopyArchiveToContainerCmd copyArchiveToContainerCmd(String s) {
        return dockerClient.copyArchiveToContainerCmd(s);
    }

    @Override
    public ContainerDiffCmd containerDiffCmd(String s) {
        return dockerClient.containerDiffCmd(s);
    }

    @Override
    public StopContainerCmd stopContainerCmd(String s) {
        return dockerClient.stopContainerCmd(s);
    }

    @Override
    public KillContainerCmd killContainerCmd(String s) {
        return dockerClient.killContainerCmd(s);
    }

    @Override
    public UpdateContainerCmd updateContainerCmd(String s) {
        return dockerClient.updateContainerCmd(s);
    }

    @Override
    public RenameContainerCmd renameContainerCmd(String s) {
        return dockerClient.renameContainerCmd(s);
    }

    @Override
    public RestartContainerCmd restartContainerCmd(String s) {
        return dockerClient.restartContainerCmd(s);
    }

    @Override
    public ResizeContainerCmd resizeContainerCmd(String s) {
        return dockerClient.resizeContainerCmd(s);
    }

    @Override
    public CommitCmd commitCmd(String s) {
        return dockerClient.commitCmd(s);
    }

    @Override
    public BuildImageCmd buildImageCmd() {
        return dockerClient.buildImageCmd();
    }

    @Override
    public BuildImageCmd buildImageCmd(File file) {
        return dockerClient.buildImageCmd(file);
    }

    @Override
    public BuildImageCmd buildImageCmd(InputStream inputStream) {
        return dockerClient.buildImageCmd(inputStream);
    }

    @Override
    public TopContainerCmd topContainerCmd(String s) {
        return dockerClient.topContainerCmd(s);
    }

    @Override
    public TagImageCmd tagImageCmd(String s, String s1, String s2) {
        return dockerClient.tagImageCmd(s,s1,s2);
    }

    @Override
    public PauseContainerCmd pauseContainerCmd(String s) {
        return dockerClient.pauseContainerCmd(s);
    }

    @Override
    public UnpauseContainerCmd unpauseContainerCmd(String s) {
        return dockerClient.unpauseContainerCmd(s);
    }

    @Override
    public EventsCmd eventsCmd() {
        return dockerClient.eventsCmd();
    }

    @Override
    public StatsCmd statsCmd(String s) {
        return dockerClient.statsCmd(s);
    }

    @Override
    public CreateVolumeCmd createVolumeCmd() {
        return dockerClient.createVolumeCmd();
    }

    @Override
    public InspectVolumeCmd inspectVolumeCmd(String s) {
        return dockerClient.inspectVolumeCmd(s);
    }

    @Override
    public RemoveVolumeCmd removeVolumeCmd(String s) {
        return dockerClient.removeVolumeCmd(s);
    }

    @Override
    public ListVolumesCmd listVolumesCmd() {
        return dockerClient.listVolumesCmd();
    }

    @Override
    public ListNetworksCmd listNetworksCmd() {
        return dockerClient.listNetworksCmd();
    }

    @Override
    public InspectNetworkCmd inspectNetworkCmd() {
        return dockerClient.inspectNetworkCmd();
    }

    @Override
    public CreateNetworkCmd createNetworkCmd() {
        return dockerClient.createNetworkCmd();
    }

    @Override
    public RemoveNetworkCmd removeNetworkCmd(String s) {
        return dockerClient.removeNetworkCmd(s);
    }

    @Override
    public ConnectToNetworkCmd connectToNetworkCmd() {
        return dockerClient.connectToNetworkCmd();
    }

    @Override
    public DisconnectFromNetworkCmd disconnectFromNetworkCmd() {
        return dockerClient.disconnectFromNetworkCmd();
    }

    @Override
    public InitializeSwarmCmd initializeSwarmCmd(SwarmSpec swarmSpec) {
        return dockerClient.initializeSwarmCmd(swarmSpec);
    }

    @Override
    public InspectSwarmCmd inspectSwarmCmd() {
        return dockerClient.inspectSwarmCmd();
    }

    @Override
    public JoinSwarmCmd joinSwarmCmd() {
        return dockerClient.joinSwarmCmd();
    }

    @Override
    public LeaveSwarmCmd leaveSwarmCmd() {
        return dockerClient.leaveSwarmCmd();
    }

    @Override
    public UpdateSwarmCmd updateSwarmCmd(SwarmSpec swarmSpec) {
        return dockerClient.updateSwarmCmd(swarmSpec);
    }

    @Override
    public UpdateSwarmNodeCmd updateSwarmNodeCmd() {
        return dockerClient.updateSwarmNodeCmd();
    }

    @Override
    public ListSwarmNodesCmd listSwarmNodesCmd() {
        return dockerClient.listSwarmNodesCmd();
    }

    @Override
    public ListServicesCmd listServicesCmd() {
        return dockerClient.listServicesCmd();
    }

    @Override
    public CreateServiceCmd createServiceCmd(ServiceSpec serviceSpec) {
        return dockerClient.createServiceCmd(serviceSpec);
    }

    @Override
    public InspectServiceCmd inspectServiceCmd(String s) {
        return dockerClient.inspectServiceCmd(s);
    }

    @Override
    public UpdateServiceCmd updateServiceCmd(String s, ServiceSpec serviceSpec) {
        return dockerClient.updateServiceCmd(s,serviceSpec);
    }

    @Override
    public RemoveServiceCmd removeServiceCmd(String s) {
        return dockerClient.removeServiceCmd(s);
    }

    @Override
    public ListTasksCmd listTasksCmd() {
        return dockerClient.listTasksCmd();
    }

    @Override
    public LogSwarmObjectCmd logServiceCmd(String s) {
        return dockerClient.logServiceCmd(s);
    }

    @Override
    public LogSwarmObjectCmd logTaskCmd(String s) {
        return dockerClient.logTaskCmd(s);
    }

    @Override
    public PruneCmd pruneCmd(PruneType pruneType) {
        return dockerClient.pruneCmd(pruneType);
    }

    @Override
    public ListSecretsCmd listSecretsCmd() {
        return dockerClient.listSecretsCmd();
    }

    @Override
    public CreateSecretCmd createSecretCmd(SecretSpec secretSpec) {
        return dockerClient.createSecretCmd(secretSpec);
    }

    @Override
    public RemoveSecretCmd removeSecretCmd(String s) {
        return dockerClient.removeSecretCmd(s);
    }

    @Override
    public void close() throws IOException {
        dockerClient.close();
    }
}
