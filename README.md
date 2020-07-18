# Difference between Fabric8 Kubernetes Client and Official Kubernetes Client

This project tries to show differences in API usages of Fabric8 and Official Kubernetes Client. It tries to give some usage examples of basic Kubernetes Operations done using both clients. I've used code in this project for my blog comparing both clients.

These are some of the use cases being showcased in this project:

| Use Case               | Fabric8 Kubernetes Client        | Official Kubernetes Client            |
| -----------------------|----------------------------------|---------------------------------------|
| `kubectl get pods`     | [PodListTest.java](https://github.com/rohanKanojia/fabric8-official-java-client-comparison/blob/master/src/main/java/io/fabric8/PodListTest.java)                 |  [TestingPodList.java](https://github.com/rohanKanojia/fabric8-official-java-client-comparison/blob/master/src/main/java/io/kubernetes/TestingPodList.java)                  |
| `kubectl create -f service.yaml` | [LoadAndCreateService.java](https://github.com/rohanKanojia/fabric8-official-java-client-comparison/blob/master/src/main/java/io/fabric8/LoadAndCreateService.java) | [LoadAndCreateService.java](https://github.com/rohanKanojia/fabric8-official-java-client-comparison/blob/master/src/main/java/io/kubernetes/LoadAndCreateService.java)          |     
| `kubectl get pods -w` | [PodWatchTest.java](https://github.com/rohanKanojia/fabric8-official-java-client-comparison/blob/master/src/main/java/io/fabric8/PodWatchTest.java) | [WatchPods.java](https://github.com/rohanKanojia/fabric8-official-java-client-comparison/blob/master/src/main/java/io/kubernetes/WatchPods.java)          |     
| `kubectl create -f deploy.yaml` | [SimpleDeploymentCreate.java](https://github.com/rohanKanojia/fabric8-official-java-client-comparison/blob/master/src/main/java/io/fabric8/SimpleDeploymentCreate.java) | [DeploymentDemo.java](https://github.com/rohanKanojia/fabric8-official-java-client-comparison/blob/master/src/main/java/io/kubernetes/DeploymentDemo.java)        |
| Creating Custom Resources`kubectl create -f dummy.yaml` | [CustomResourceCreateDemo.java](https://github.com/rohanKanojia/fabric8-official-java-client-comparison/blob/master/src/main/java/io/fabric8/CustomResourceCreateDemo.java),[CustomResourceCreateDemoTypeless.java](https://github.com/rohanKanojia/fabric8-official-java-client-comparison/blob/master/src/main/java/io/fabric8/CustomResourceCreateDemoTypeless.java) | [CustomResourceDemo.java](https://github.com/rohanKanojia/fabric8-official-java-client-comparison/blob/master/src/main/java/io/kubernetes/CustomResourceDemo.java)        |



