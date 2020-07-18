# Difference between Fabric8 Kubernetes Client and Official Kubernetes Client

This project tries to show differences in API usages of Fabric8 and Official Kubernetes Client. It tries to give some usage examples of basic Kubernetes Operations done using both clients. I've used code in this project for my blog comparing both clients.

These are some of the use cases being showcased in this project:

| Use Case               | Fabric8 Kubernetes Client        | Official Kubernetes Client            |
| -----------------------|----------------------------------|---------------------------------------|
| `kubectl get pods`     | PodListTest.java                 |  TestingPodList.java                  |
| `kubectl create -f service.yaml` | LoadAndCreateService.java | LoadAndCreateService.java          |     
| `kubectl get pods -w` | PodWatchTest.java | WatchPods.java          |     
| `kubectl create -f deploy.yaml` | SimpleDeploymentCreate.java | DeploymentDemo.java        |
| Creating Custom Resources`kubectl create -f dummy.yaml` | CustomResourceCreateDemo.java,CustomResourceCreateDemoTypeless.java | CustomResourceDemo.java        |



