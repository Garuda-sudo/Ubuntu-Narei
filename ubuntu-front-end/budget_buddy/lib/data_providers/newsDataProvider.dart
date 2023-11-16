import 'package:budget_buddy/models/news_model.dart';
import 'package:budget_buddy/services/newApiService.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';

final newsDataProvider = FutureProvider<String>(
  (ref) async {
    return await ref.watch(newsProvider).getArticles();
  },
);
