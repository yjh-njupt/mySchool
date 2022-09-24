package drive;



public class MongoDbTest {
    /*private static final Logger log  = LoggerFactory.getLogger(MongoDbTest.class);
    //mongoClient连接
    protected static MongoClient mongoClient;

    public synchronized static void getInstance(String mongodbUrl) {
        if (null == mongoClient) {
            mongoClient = MongoClients.create(mongodbUrl);
            //MongoClients.create(MongoClientSettings.builder().applyToClusterSettings(builder -> builder.hosts(Arrays.asList(new ServerAddress("host1",27017)))).build());
            if (null != mongoClient) {
                log.info("mongoClient init success!");
            } else {
                log.info("mongoClient init failed!");
            }
        }
    }

    // 创建集合
    public  static void createCollection(String dataBaseName,String collectionName){
        getDatabase(dataBaseName).createCollection(collectionName);
    }
    // 查询dataBaseName
    public static MongoDatabase getDatabase(String dataBaseName){ return mongoClient.getDatabase(dataBaseName); }


    public static MongoCollection<Document> getCollectionByName(String dataBaseName, String collectionName){ return getDatabase(dataBaseName).getCollection(collectionName); }

    @Before
    public void before(){
       // getInstance("mongodb://admin:123456@192.168.135.131:27017/test");
        getInstance("mongodb://192.168.135.131:27017");
    }

    @Test
    public void demo(){

        BasicDBObject id = new BasicDBObject().append("_id", "62f915c98e7424593b4bc6a3");  //精准查询
        FindIterable<Document> documents = getCollectionByName("test", "product").find(id);
        for (Document document:
             documents) {
            System.out.println("~~~~~~~~~~~~~" + document.toString());
        }


    }



    @After
    public void after(){
        if (mongoClient != null) {
            mongoClient.close();
        }
    }

    @Test
    public void demo1() throws Exception{

    }*/
}
