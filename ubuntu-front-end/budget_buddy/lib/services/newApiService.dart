import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:http/http.dart';

class NewsApiService {
  String newsCatcherEndpoint = "https://jsonplaceholder.typicode.com/todos/1";
  // Map<String, String> newsHeader = {
  //   "x-api-key": "eFC3F7kqHXGLHeqpNszFLggUy6Rg5I7jnQ6POnNb154"
  // };

  Future getArticles() async {
    Response response = await get(Uri.parse(newsCatcherEndpoint));

    if (response.statusCode == 200) {
      //print(response.body.toString());
      final String result = response.body.toString();
      return result;

      //TODO Need to map newscatcher to its model
    } else {
      throw Exception(response.reasonPhrase);
    }
  }
}

final newsProvider = Provider<NewsApiService>((ref) => NewsApiService());
