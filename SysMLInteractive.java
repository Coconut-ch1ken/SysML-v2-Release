/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Predicates
 *  com.google.common.base.Strings
 *  com.google.inject.Inject
 *  com.google.inject.Injector
 *  org.eclipse.emf.common.util.BasicEList
 *  org.eclipse.emf.common.util.EList
 *  org.eclipse.emf.ecore.EObject
 *  org.eclipse.emf.ecore.EPackage$Registry
 *  org.eclipse.emf.ecore.resource.Resource
 *  org.eclipse.xtext.parser.IParseResult
 *  org.eclipse.xtext.resource.IEObjectDescription
 *  org.eclipse.xtext.resource.XtextResource
 *  org.eclipse.xtext.resource.impl.ResourceDescriptionsData
 *  org.eclipse.xtext.scoping.IGlobalScopeProvider
 *  org.eclipse.xtext.scoping.IScope
 *  org.eclipse.xtext.util.CancelIndicator
 *  org.eclipse.xtext.validation.CheckMode
 *  org.eclipse.xtext.validation.IResourceValidator
 *  org.eclipse.xtext.validation.Issue
 *  org.omg.kerml.xtext.KerMLStandaloneSetup
 *  org.omg.kerml.xtext.library.ILibraryIndexProvider
 *  org.omg.kerml.xtext.naming.KerMLQualifiedNameConverter
 *  org.omg.kerml.xtext.xmi.KerMLxStandaloneSetup
 *  org.omg.sysml.execution.expressions.ExpressionEvaluator
 *  org.omg.sysml.interactive.StrictShadowingResourceDescriptionData
 *  org.omg.sysml.interactive.SysMLInteractive$LinkProvider
 *  org.omg.sysml.interactive.SysMLInteractiveHelp
 *  org.omg.sysml.interactive.SysMLInteractiveResult
 *  org.omg.sysml.interactive.SysMLInteractiveUtil
 *  org.omg.sysml.interactive.VizResult
 *  org.omg.sysml.lang.sysml.Element
 *  org.omg.sysml.lang.sysml.Expression
 *  org.omg.sysml.lang.sysml.Namespace
 *  org.omg.sysml.lang.sysml.RenderingUsage
 *  org.omg.sysml.lang.sysml.ResultExpressionMembership
 *  org.omg.sysml.lang.sysml.SysMLFactory
 *  org.omg.sysml.lang.sysml.SysMLPackage
 *  org.omg.sysml.lang.sysml.Type
 *  org.omg.sysml.lang.sysml.ViewUsage
 *  org.omg.sysml.lang.sysml.util.SysMLLibraryUtil
 *  org.omg.sysml.plantuml.SysML2PlantUMLLinkProvider
 *  org.omg.sysml.plantuml.SysML2PlantUMLSvc
 *  org.omg.sysml.util.SysMLUtil
 *  org.omg.sysml.util.TypeUtil
 *  org.omg.sysml.util.repository.APIModel
 *  org.omg.sysml.util.repository.EMFModelDelta
 *  org.omg.sysml.util.repository.EMFModelRefresher
 *  org.omg.sysml.util.repository.EObjectUUIDTracker
 *  org.omg.sysml.util.repository.ProjectRepository
 *  org.omg.sysml.util.repository.RemoteProject
 *  org.omg.sysml.util.repository.RemoteProject$RemoteBranch
 *  org.omg.sysml.util.repository.Revision
 *  org.omg.sysml.util.traversal.Traversal
 *  org.omg.sysml.util.traversal.facade.ElementProcessingFacade
 *  org.omg.sysml.util.traversal.facade.impl.ApiElementProcessingFacade
 *  org.omg.sysml.util.traversal.facade.impl.JsonElementProcessingFacade
 *  org.omg.sysml.xtext.SysMLStandaloneSetup
 *  org.omg.sysml.xtext.xmi.SysMLxStandaloneSetup
 */
package org.omg.sysml.interactive;

import com.google.common.base.Predicates;
import com.google.common.base.Strings;
import com.google.inject.Inject;
import com.google.inject.Injector;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;
import java.util.stream.Collectors;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsData;
import org.eclipse.xtext.scoping.IGlobalScopeProvider;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import org.omg.kerml.xtext.KerMLStandaloneSetup;
import org.omg.kerml.xtext.library.ILibraryIndexProvider;
import org.omg.kerml.xtext.naming.KerMLQualifiedNameConverter;
import org.omg.kerml.xtext.xmi.KerMLxStandaloneSetup;
import org.omg.sysml.execution.expressions.ExpressionEvaluator;
import org.omg.sysml.interactive.StrictShadowingResourceDescriptionData;
import org.omg.sysml.interactive.SysMLInteractive;
import org.omg.sysml.interactive.SysMLInteractiveHelp;
import org.omg.sysml.interactive.SysMLInteractiveResult;
import org.omg.sysml.interactive.SysMLInteractiveUtil;
import org.omg.sysml.interactive.VizResult;
import org.omg.sysml.lang.sysml.Element;
import org.omg.sysml.lang.sysml.Expression;
import org.omg.sysml.lang.sysml.Namespace;
import org.omg.sysml.lang.sysml.RenderingUsage;
import org.omg.sysml.lang.sysml.ResultExpressionMembership;
import org.omg.sysml.lang.sysml.SysMLFactory;
import org.omg.sysml.lang.sysml.SysMLPackage;
import org.omg.sysml.lang.sysml.Type;
import org.omg.sysml.lang.sysml.ViewUsage;
import org.omg.sysml.lang.sysml.util.SysMLLibraryUtil;
import org.omg.sysml.plantuml.SysML2PlantUMLLinkProvider;
import org.omg.sysml.plantuml.SysML2PlantUMLSvc;
import org.omg.sysml.util.SysMLUtil;
import org.omg.sysml.util.TypeUtil;
import org.omg.sysml.util.repository.APIModel;
import org.omg.sysml.util.repository.EMFModelDelta;
import org.omg.sysml.util.repository.EMFModelRefresher;
import org.omg.sysml.util.repository.EObjectUUIDTracker;
import org.omg.sysml.util.repository.ProjectRepository;
import org.omg.sysml.util.repository.RemoteProject;
import org.omg.sysml.util.repository.Revision;
import org.omg.sysml.util.traversal.Traversal;
import org.omg.sysml.util.traversal.facade.ElementProcessingFacade;
import org.omg.sysml.util.traversal.facade.impl.ApiElementProcessingFacade;
import org.omg.sysml.util.traversal.facade.impl.JsonElementProcessingFacade;
import org.omg.sysml.xtext.SysMLStandaloneSetup;
import org.omg.sysml.xtext.xmi.SysMLxStandaloneSetup;

public class SysMLInteractive
extends SysMLUtil {
    public static final String HELP_KEY = "help";
    public static final String PROJECT_ID_KEY = "id";
    public static final String PROJECT_NAME_KEY = "name";
    public static final String BRANCH_ID_KEY = "branch-id";
    public static final String BRANCH_NAME_KEY = "branch";
    public static final String KERNEL_LIBRARIES_DIRECTORY = "Kernel Libraries";
    public static final String SYSTEMS_LIBRARY_DIRECTORY = "Systems Library";
    public static final String DOMAIN_LIBRARIES_DIRECTORY = "Domain Libraries";
    public static final String KERML_EXTENSION = ".kerml";
    public static final String SYSML_EXTENSION = ".sysml";
    public static final String KERMLX_EXTENSION = ".kermlx";
    public static final String SYSMLX_EXTENSION = ".sysmlx";
    protected static Injector injector;
    protected static SysMLInteractive instance;
    protected String apiBasePath = "http://sysml2-dev.intercax.com:9000";
    protected int counter = 1;
    protected Resource resource;
    protected Traversal traversal;
    protected SysML2PlantUMLSvc sysml2PlantUMLSvc;
    private Resource dummyResource;
    @Inject
    private IGlobalScopeProvider scopeProvider;
    @Inject
    private KerMLQualifiedNameConverter qualifiedNameConverter;
    @Inject
    private IResourceValidator validator;
    @Inject
    private ILibraryIndexProvider libraryIndexCache;
    private EObjectUUIDTracker tracker = new EObjectUUIDTracker();

    static {
        instance = null;
    }

    @Inject
    private SysMLInteractive() {
        super((ResourceDescriptionsData)new StrictShadowingResourceDescriptionData());
    }

    public void loadLibrary(String path) {
        if (path != null) {
            if (!((String)path).endsWith("/")) {
                path = (String)path + "/";
            }
            SysMLLibraryUtil.setModelLibraryDirectory((String)path);
            this.readAll((String)path + KERNEL_LIBRARIES_DIRECTORY, false, KERML_EXTENSION);
            this.readAll((String)path + SYSTEMS_LIBRARY_DIRECTORY, false, SYSML_EXTENSION);
            this.readAll((String)path + DOMAIN_LIBRARIES_DIRECTORY, false, SYSML_EXTENSION);
        }
    }

    public void setApiBasePath(String apiBasePath) {
        this.apiBasePath = apiBasePath;
    }

    public String getApiBasePath() {
        return this.apiBasePath;
    }

    public int next(String extension) {
        this.resource = this.createResource(this.counter + extension);
        this.addInputResource(this.resource);
        return this.counter++;
    }

    public Resource getResource() {
        return this.resource;
    }

    public ILibraryIndexProvider getLibraryIndexCache() {
        return this.libraryIndexCache;
    }

    public void removeResource() {
        if (this.resource != null) {
            try {
                this.resource.delete(null);
                this.resource = null;
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public Element getRootElement() {
        Resource resource = this.getResource();
        if (resource instanceof XtextResource) {
            XtextResource xtextResource = (XtextResource)resource;
            IParseResult result = xtextResource.getParseResult();
            return result == null ? null : (Element)result.getRootASTElement();
        }
        EList contents = resource.getContents();
        return contents.isEmpty() ? null : (Element)contents.get(0);
    }

    public void parse(String input) throws IOException {
        Resource resource = this.getResource();
        if (resource instanceof XtextResource) {
            XtextResource xtextResource = (XtextResource)resource;
            xtextResource.reparse(input);
        }
    }

    public List<Issue> validate() {
        Resource resource = this.getResource();
        return resource == null ? Collections.emptyList() : this.validator.validate(resource, CheckMode.ALL, CancelIndicator.NullImpl);
    }

    private Resource getDummyResource() {
        if (this.dummyResource == null) {
            this.dummyResource = this.createResource("dummy.sysml");
            this.dummyResource.getContents().add((Object)SysMLFactory.eINSTANCE.createNamespace());
        }
        return this.dummyResource;
    }

    public Element resolve(String name) {
        IScope scope = this.scopeProvider.getScope(this.getDummyResource(), SysMLPackage.eINSTANCE.getNamespace_Member(), Predicates.alwaysTrue());
        IEObjectDescription description = scope.getSingleElement(this.qualifiedNameConverter.toQualifiedName(name));
        if (description == null) {
            return null;
        }
        EObject object = description.getEObjectOrProxy();
        return object instanceof Element ? (Element)object : null;
    }

    public SysMLInteractiveResult process(String input) {
        return this.process(input, true);
    }

    public SysMLInteractiveResult process(String input, boolean isAddResource) {
        this.next(SYSML_EXTENSION);
        try {
            this.parse(input);
            List<Issue> issues = this.validate();
            Element rootElement = this.getRootElement();
            SysMLInteractiveResult result = new SysMLInteractiveResult(rootElement, issues);
            if (result.hasErrors()) {
                this.removeResource();
            } else if (isAddResource) {
                this.addResourceToIndex(this.resource);
            }
            return result;
        }
        catch (Exception e) {
            this.removeResource();
            return new SysMLInteractiveResult(e);
        }
    }

    public String help(String command, List<String> help) {
        String helpString;
        ++this.counter;
        if (Strings.isNullOrEmpty((String)command)) {
            return help.isEmpty() ? SysMLInteractiveHelp.getGeneralHelp() : SysMLInteractiveHelp.getHelpHelp();
        }
        if (!((String)command).startsWith("%")) {
            command = "%" + (String)command;
        }
        return (helpString = SysMLInteractiveHelp.getHelpString((String)command)) == null ? SysMLInteractiveHelp.getGeneralHelp() : helpString;
    }

    public String help(String command) {
        return "-h".equals(command) ? this.help(null, Collections.singletonList("true")) : this.help(command, Collections.emptyList());
    }

    public String repo(String apiBasePath, List<String> help) {
        ++this.counter;
        if (!help.isEmpty()) {
            return SysMLInteractiveHelp.getRepoPathHelp();
        }
        if (!Strings.isNullOrEmpty((String)apiBasePath)) {
            this.setApiBasePath(apiBasePath);
        }
        return this.getApiBasePath() + "\n";
    }

    public String repo(String command) {
        return "-h".equals(command) ? this.repo(null, Collections.singletonList("true")) : this.repo(command, Collections.emptyList());
    }

    public String eval(String input, String targetName, List<String> help) {
        if (Strings.isNullOrEmpty((String)input)) {
            ++this.counter;
            return help.isEmpty() ? "" : SysMLInteractiveHelp.getEvalHelp();
        }
        if (input == null || ((String)input).isEmpty()) {
            ++this.counter;
            return "";
        }
        Element target = null;
        if (Strings.isNullOrEmpty((String)targetName)) {
            input = "calc{\n" + (String)input + "}";
        } else {
            target = this.resolve(targetName);
            if (target == null) {
                ++this.counter;
                return "ERROR:Couldn't resolve reference to Element '" + targetName + "'\n";
            }
            input = "calc{private import " + targetName + "::*;\n" + (String)input + "}";
        }
        SysMLInteractiveResult result = this.process((String)input, false);
        if (result.hasErrors()) {
            return result.toString();
        }
        Type calc = (Type)((Namespace)result.getRootElement()).getOwnedMember().get(0);
        Expression expr = (Expression)TypeUtil.getFeatureByMembershipIn((Type)calc, ResultExpressionMembership.class);
        EList elements = ExpressionEvaluator.INSTANCE.evaluate(expr, target);
        this.removeResource();
        return elements == null ? "" : elements.stream().map(SysMLInteractiveUtil::formatElement).collect(Collectors.joining());
    }

    public String eval(String input, String targetName) {
        return "-h".equals(input) ? this.eval(null, null, Collections.singletonList("true")) : this.eval(input, targetName, Collections.emptyList());
    }

    public String listLibrary() {
        ++this.counter;
        try {
            List globalMemberships = this.getLibraryResources().stream().flatMap(r -> r.getContents().stream()).filter(Namespace.class::isInstance).flatMap(n -> ((Namespace)n).visibleMemberships((EList)new BasicEList(), false, false).stream()).collect(Collectors.toList());
            return SysMLInteractiveUtil.formatMembershipList(globalMemberships);
        }
        catch (Exception e) {
            return SysMLInteractiveUtil.formatException((Exception)e);
        }
    }

    public String listQuery(String query) {
        SysMLInteractiveResult result;
        if (!((String)query).endsWith(";")) {
            query = (String)query + ";";
        }
        if ((result = this.process("private import " + (String)query, false)).hasErrors()) {
            return result.toString();
        }
        EList memberships = ((Namespace)result.getRootElement()).getImportedMembership();
        this.removeResource();
        return SysMLInteractiveUtil.formatMembershipList((List)memberships);
    }

    public String list(String query, List<String> help) {
        return Strings.isNullOrEmpty((String)query) ? (!help.isEmpty() ? SysMLInteractiveHelp.getListHelp() : this.listLibrary()) : this.listQuery(query);
    }

    protected String list(String query) {
        return "-h".equals(query) ? this.list(null, Collections.singletonList("true")) : this.list(query, Collections.emptyList());
    }

    public Object show(String name, List<String> styles, List<String> help) {
        ++this.counter;
        if (Strings.isNullOrEmpty((String)name)) {
            return help.isEmpty() ? "" : SysMLInteractiveHelp.getShowHelp();
        }
        try {
            Element element = this.resolve(name);
            if (element == null) {
                return "ERROR:Couldn't resolve reference to Element '" + name + "'\n";
            }
            if (SysMLInteractive.matchStyle(styles, "JSON")) {
                JsonElementProcessingFacade processingFacade = this.getJsonElementProcessingFacade();
                processingFacade.getTraversal().visit(element);
                return processingFacade.toJsonTree(true);
            }
            if (styles.isEmpty() || SysMLInteractive.matchStyle(styles, "TREE")) {
                return SysMLInteractiveUtil.formatTree((Element)element);
            }
            return "ERROR:Invalid style. Possible styles: TREE and JSON\n";
        }
        catch (Exception e) {
            return SysMLInteractiveUtil.formatException((Exception)e);
        }
    }

    public Object export(String name, List<String> help) {
        ++this.counter;
        if (Strings.isNullOrEmpty((String)name)) {
            return help.isEmpty() ? "" : SysMLInteractiveHelp.getExportHelp();
        }
        try {
            Element element = this.resolve(name);
            if (element == null) {
                return "ERROR:Couldn't resolve reference to Element '" + name + "'\n";
            }
            JsonElementProcessingFacade processingFacade = this.getJsonElementProcessingFacade();
            processingFacade.getTraversal().visit(element);
            return processingFacade.toJsonTree(true);
        }
        catch (Exception e) {
            return SysMLInteractiveUtil.formatException((Exception)e);
        }
    }

    public String show(String name) {
        int i;
        if (name.startsWith("--style=") && (i = name.indexOf(" ")) > 0) {
            String style = name.substring("--style=".length(), i).toUpperCase();
            name = name.substring(i).trim();
            return this.show(name, Collections.singletonList(style), Collections.emptyList()).toString() + "\n";
        }
        return (String)("-h".equals(name) ? this.show(null, Collections.emptyList(), Collections.singletonList("true")) : this.show(name, Collections.emptyList(), Collections.emptyList()));
    }

    public String publish(String elementName, String projectName, String branchName, boolean includeDerievd, List<String> help) {
        ++this.counter;
        if (Strings.isNullOrEmpty((String)elementName)) {
            return help.isEmpty() ? "" : SysMLInteractiveHelp.getPublishHelp();
        }
        try {
            Element element = this.resolve(elementName);
            if (element == null) {
                return "ERROR:Couldn't resolve reference to Element '" + elementName + "'\n";
            }
            if (!this.isInputResource(element.eResource())) {
                return "ERROR:'" + elementName + "' is a library element\n";
            }
            String remoteProjectName = projectName == null ? element.getDeclaredName() : projectName;
            ApiElementProcessingFacade processingFacade = this.getApiElementProcessingFacade(remoteProjectName, branchName, includeDerievd);
            processingFacade.getTraversal().visit(element);
            processingFacade.commit(element);
            System.out.println();
            return "Saved to Project " + remoteProjectName + " (" + processingFacade.getProjectId() + ")\n";
        }
        catch (Exception e) {
            return SysMLInteractiveUtil.formatException((Exception)e);
        }
    }

    protected String publish(String name) {
        return "-h".equals(name) ? this.publish(null, null, null, false, Collections.singletonList("true")) : this.publish(name, null, null, false, Collections.emptyList());
    }

    public String load(Map<String, String> parameters) {
        RemoteProject.RemoteBranch branch;
        RemoteProject project;
        ++this.counter;
        if (parameters.containsKey(HELP_KEY)) {
            return SysMLInteractiveHelp.getLoadHelp();
        }
        if (parameters.containsKey(PROJECT_ID_KEY) && parameters.containsKey(PROJECT_NAME_KEY)) {
            return "ERROR:Project name and id cannot be provided at the same time\n";
        }
        if (parameters.containsKey(BRANCH_ID_KEY) && parameters.containsKey(BRANCH_NAME_KEY)) {
            return "ERROR:Branch name and id cannot be provided at the same time\n";
        }
        System.out.println("API base path: " + this.apiBasePath);
        System.out.println();
        ProjectRepository repository = new ProjectRepository(this.apiBasePath);
        if (parameters.containsKey(PROJECT_ID_KEY)) {
            String projectId = parameters.get(PROJECT_ID_KEY);
            project = repository.getProjectById(projectId);
        } else if (parameters.containsKey(PROJECT_NAME_KEY)) {
            String projectName = parameters.get(PROJECT_NAME_KEY);
            project = repository.getProjectByName(projectName);
        } else {
            return SysMLInteractiveHelp.getLoadHelp();
        }
        if (project == null) {
            return "ERROR:Project doesn't exist\n";
        }
        if (parameters.containsKey(BRANCH_NAME_KEY)) {
            String branchName = parameters.get(BRANCH_NAME_KEY);
            branch = project.getBranch(branchName);
        } else if (parameters.containsKey(BRANCH_ID_KEY)) {
            String branchIdString = parameters.get(BRANCH_ID_KEY);
            UUID branchId = UUID.fromString(branchIdString);
            branch = project.getBranch(branchId);
        } else {
            branch = project.getDefaultBranch();
        }
        return this.load(branch);
    }

    private String load(RemoteProject.RemoteBranch branch) {
        if (branch == null) {
            return "ERROR:Branch doesn't exist\n";
        }
        System.out.println("Selected branch " + branch.getName() + " (" + branch.getRemoteId().toString() + ")");
        Revision headRevision = branch.getHeadRevision();
        if (!headRevision.isRemote()) {
            return "ERROR:Branch has no head commit\n";
        }
        if (!this.tracker.isLibraryTracked()) {
            System.out.println("Caching library UUIDs...");
            this.tracker.trackLibraryUUIDs((Collection)this.getLibraryResources());
        }
        this.tracker.clear();
        List inputResources = this.getInputResources();
        this.tracker.trackLocalUUIDs((Collection)inputResources);
        System.out.println("Downloading model...");
        APIModel model = headRevision.fetchRemote();
        EMFModelRefresher modelRefresher = new EMFModelRefresher(model, this.tracker);
        EMFModelDelta delta = modelRefresher.create();
        modelRefresher.getIssues().forEach(System.out::println);
        delta.getProjectRootsAsNamespaces().forEach(rootNs -> {
            Resource resource = this.createResource(rootNs.toString() + SYSML_EXTENSION);
            resource.getContents().add(rootNs);
            this.addInputResource(resource);
            this.addResourceToIndex(resource);
        });
        RemoteProject remoteProject = branch.getRemoteProject();
        return "Loaded Project " + remoteProject.getProjectName() + " (" + remoteProject.getRemoteId().toString() + ")\n";
    }

    protected String load(String name) {
        return "-h".equals(name) ? this.load(Map.of(HELP_KEY, "true")) : this.load(Map.of(PROJECT_NAME_KEY, name));
    }

    public String projects(List<String> help) {
        ++this.counter;
        if (help != null && !help.isEmpty()) {
            return SysMLInteractiveHelp.getProjectsHelp();
        }
        ProjectRepository projectRepository = new ProjectRepository(this.apiBasePath);
        Comparator projectNameComparator = Comparator.nullsFirst(Comparator.naturalOrder());
        String apiBasePathString = "API base path: " + this.apiBasePath;
        List repositoryProjects = projectRepository.getProjects();
        String projectsListString = repositoryProjects.stream().sorted((p1, p2) -> projectNameComparator.compare(p1.getProjectName(), p2.getProjectName())).map(p -> String.format("Project %s (%s)", p.getProjectName(), p.getRemoteId())).collect(Collectors.joining("\n"));
        return apiBasePathString + "\n\n" + projectsListString + "\n";
    }

    protected String projects(String arg) {
        return "-h".equals(arg) ? this.projects(Collections.singletonList("true")) : this.projects(Collections.emptyList());
    }

    protected ApiElementProcessingFacade getApiElementProcessingFacade(String modelName, String branchName, boolean includeDerived) {
        System.out.println("API base path: " + this.apiBasePath);
        ApiElementProcessingFacade processingFacade = new ApiElementProcessingFacade(modelName, branchName, this.apiBasePath);
        processingFacade.setIsIncludeDerived(includeDerived);
        processingFacade.setTraversal(new Traversal((ElementProcessingFacade)processingFacade));
        return processingFacade;
    }

    protected JsonElementProcessingFacade getJsonElementProcessingFacade() {
        JsonElementProcessingFacade processingFacade = new JsonElementProcessingFacade();
        processingFacade.setIsIncludeDerived(true);
        processingFacade.setTraversal(new Traversal((ElementProcessingFacade)processingFacade));
        return processingFacade;
    }

    public VizResult view(String name, List<String> renders, List<String> styles, List<String> help) {
        ++this.counter;
        if (!help.isEmpty() || name == null && renders.isEmpty() && styles.isEmpty()) {
            return VizResult.textResult((String)SysMLInteractiveHelp.getViewHelp());
        }
        if (name == null) {
            return VizResult.emptyResult();
        }
        Element element = this.resolve(name);
        if (element == null) {
            return VizResult.unresolvedResult((String)name);
        }
        if (!(element instanceof ViewUsage)) {
            return VizResult.vizExceptionResult((String)("ERROR:'" + name + "' is not a view\n"));
        }
        ViewUsage viewSpec = (ViewUsage)element;
        RenderingUsage rendering = viewSpec.getViewRendering();
        if (rendering != null) {
            String renderingName = rendering.getName();
            if ("asTreeDiagram".equals(renderingName)) {
                renders.add(0, "TREE");
            } else if ("asInterconnectionDiagram".equals(renderingName)) {
                renders.add(0, "INTERCONNECTION");
            } else {
                return VizResult.vizExceptionResult((String)("ERROR:Rendering " + renderingName + " is not a supported\n"));
            }
        }
        ArrayList<EObject> elements = new ArrayList<EObject>();
        elements.addAll((Collection<EObject>)viewSpec.getExposedElement());
        return this.viz(elements, renders, styles);
    }

    protected VizResult view(String name) {
        return "-h".equals(name) ? this.view(null, new ArrayList<String>(), Collections.emptyList(), Collections.singletonList("true")) : this.view(name, new ArrayList<String>(), Collections.singletonList("PUMLCODE"), Collections.emptyList());
    }

    public VizResult viz(List<String> names, List<String> views, List<String> styles, List<String> help) {
        ++this.counter;
        if (!help.isEmpty() || names.isEmpty() && views.isEmpty() && styles.isEmpty()) {
            return VizResult.textResult((String)SysMLInteractiveHelp.getVizHelp());
        }
        ArrayList<EObject> elements = new ArrayList<EObject>(names.size());
        for (String name : names) {
            Element element = this.resolve(name);
            if (element != null) {
                elements.add((EObject)element);
                continue;
            }
            return VizResult.unresolvedResult((String)name);
        }
        return this.viz(elements, views, styles);
    }

    protected VizResult viz(List<EObject> elements, List<String> views, List<String> styles) {
        if (elements.isEmpty()) {
            return VizResult.emptyResult();
        }
        try {
            List<String> fStyles;
            SysML2PlantUMLSvc svc = this.getSysML2PlantUMLSvc();
            if (!views.isEmpty()) {
                String view = views.get(0);
                svc.setView(view);
            }
            if ((fStyles = SysMLInteractive.filterStyle(styles, "PUMLCODE")).size() != styles.size()) {
                return VizResult.plantumlResult((String)svc.getPlantUMLCode(elements, fStyles));
            }
            return VizResult.svgResult((String)svc.getSVG(elements, fStyles));
        }
        catch (Exception e) {
            return VizResult.exceptionResult((Exception)e);
        }
    }

    protected VizResult viz(String name) {
        return "-h".equals(name) ? this.viz(Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.singletonList("true")) : this.viz(Collections.singletonList(name), Collections.emptyList(), Collections.singletonList("PUMLCODE"), Collections.emptyList());
    }

    private static List<String> filterStyle(List<String> styles, String name) {
        return styles.stream().filter(x -> !x.toUpperCase().equals(name)).collect(Collectors.toList());
    }

    private static boolean matchStyle(List<String> styles, String name) {
        return styles.stream().anyMatch(x -> x.toUpperCase().equals(name));
    }

    protected SysML2PlantUMLSvc getSysML2PlantUMLSvc() {
        if (this.sysml2PlantUMLSvc == null) {
            this.sysml2PlantUMLSvc = new SysML2PlantUMLSvc((SysML2PlantUMLLinkProvider)new LinkProvider(this));
        }
        return this.sysml2PlantUMLSvc;
    }

    public void setGraphVizPath(String path) {
        this.getSysML2PlantUMLSvc().setGraphVizPath(path);
    }

    public void run(String input) {
        if (input != null && !input.isEmpty()) {
            System.out.print(this.process(input));
        }
    }

    public void run() {
        block29: {
            Throwable throwable = null;
            Object var2_3 = null;
            try (Scanner in = new Scanner(System.in);){
                while (true) {
                    try {
                        while (true) {
                            System.out.print(this.counter + "> ");
                            Object input = in.nextLine().trim();
                            if (((String)input).startsWith("%")) {
                                String argument;
                                if ("%".equals(input)) {
                                    input = "";
                                    String line = in.nextLine();
                                    while (!"%".equals(line.trim())) {
                                        if ("%%".equals(line.trim())) {
                                            input = null;
                                            break;
                                        }
                                        input = (String)input + line + "\n";
                                        line = in.nextLine();
                                    }
                                    this.run((String)input);
                                    continue;
                                }
                                int i = ((String)input).indexOf(32);
                                String command = i == -1 ? input : ((String)input).substring(0, i);
                                String string = argument = i == -1 ? "" : ((String)input).substring(i + 1).trim();
                                if ("%exit".equals(command)) {
                                    break block29;
                                }
                                if ("%help".equals(command)) {
                                    System.out.print(this.help(argument));
                                    continue;
                                }
                                if ("%list".equals(command)) {
                                    System.out.print(this.list(argument));
                                    continue;
                                }
                                if ("%show".equals(command)) {
                                    if ("".equals(argument)) continue;
                                    System.out.print(this.show(argument));
                                    continue;
                                }
                                if ("%projects".equals(command)) {
                                    System.out.print(this.projects(argument));
                                    continue;
                                }
                                if ("%repo".equals(command)) {
                                    System.out.print(this.repo(argument));
                                    continue;
                                }
                                if ("%publish".equals(command)) {
                                    if ("".equals(argument)) continue;
                                    System.out.print(this.publish(argument));
                                    continue;
                                }
                                if ("%load".equals(command)) {
                                    if ("".equals(argument)) continue;
                                    System.out.print(this.load(argument));
                                    continue;
                                }
                                if ("%viz".equals(command)) {
                                    if ("".equals(argument)) continue;
                                    System.out.print(this.viz(argument));
                                    continue;
                                }
                                if ("%view".equals(command)) {
                                    if ("".equals(argument)) continue;
                                    System.out.print(this.view(argument));
                                    continue;
                                }
                                if ("%eval".equals(command)) {
                                    if ("".equals(argument)) continue;
                                    String name = null;
                                    if (argument.startsWith("--target ") || argument.startsWith("--target=")) {
                                        i = (argument = argument.substring(9)).indexOf(32);
                                        name = i == -1 ? argument : argument.substring(0, i);
                                        argument = i == -1 ? null : argument.substring(i + 1).trim();
                                    }
                                    System.out.print(this.eval(argument, name));
                                    continue;
                                }
                                System.out.println("ERROR:Invalid command '" + (String)input + "'");
                                continue;
                            }
                            this.run((String)input);
                        }
                    }
                    catch (Exception e) {
                        e.printStackTrace();
                        continue;
                    }
                    break;
                }
            }
            catch (Throwable throwable2) {
                if (throwable == null) {
                    throwable = throwable2;
                } else if (throwable != throwable2) {
                    throwable.addSuppressed(throwable2);
                }
                throw throwable;
            }
        }
    }

    public static SysMLInteractive createInstance() {
        if (injector == null) {
            EPackage.Registry.INSTANCE.put((Object)"https://www.omg.org/spec/SysML/20250201", (Object)SysMLPackage.eINSTANCE);
            KerMLStandaloneSetup.doSetup();
            KerMLxStandaloneSetup.doSetup();
            SysMLxStandaloneSetup.doSetup();
            injector = new SysMLStandaloneSetup().createInjectorAndDoEMFRegistration();
        }
        return (SysMLInteractive)((Object)injector.getInstance(SysMLInteractive.class));
    }

    public static SysMLInteractive getInstance() {
        if (instance == null) {
            instance = SysMLInteractive.createInstance();
        }
        return instance;
    }

    public static void main(String[] args) {
        System.out.println("SysML v2 Pilot Implementation");
        SysMLInteractive instance = SysMLInteractive.getInstance();
        if (args.length > 0) {
            instance.loadLibrary(args[0]);
            if (args.length > 1) {
                instance.setApiBasePath(args[1]);
            }
        }
        instance.run();
    }
}
