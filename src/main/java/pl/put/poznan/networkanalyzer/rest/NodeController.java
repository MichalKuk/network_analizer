package pl.put.poznan.networkanalyzer.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.networkanalyzer.service.NodeService;
import pl.put.poznan.networkanalyzer.model.Node;

import java.util.List;

@RestController
@RequestMapping("/node")
public class NodeController {


    private final NodeService nodeService;
    @Autowired
    public NodeController(NodeService nodeService) {
        this.nodeService = nodeService;
    }

    @GetMapping("/{id}")
    public Node getOneNode(@PathVariable String id){
        return nodeService.getOneNode(id);
    }

    @GetMapping
    public List<Node> getAllNodes(){
        return nodeService.getAllNodes();
    }

    @PostMapping
    public void addNode(@RequestBody Node n){nodeService.addNode(n);}

    @PutMapping("/{id}")
    public void updateNode(@PathVariable String id, @RequestBody Node n){nodeService.updateNode(id,n);}

    @DeleteMapping("/{id}")
    public void deleteNode(@PathVariable String id){ nodeService.deleteNode(id);}

}
