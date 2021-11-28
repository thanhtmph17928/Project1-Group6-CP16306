package manga.readder.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.fragment.app.Fragment;

import manga.readder.Model.Chapter;
import manga.readder.R;


public class ReadMangaFragment extends Fragment {
    View view;
    WebView webView;
    Chapter chapter;
    String linkChap;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_read_manga, container, false);
        Bundle bundleRecive = getArguments();
        if (bundleRecive != null) {
            chapter = (Chapter) bundleRecive.get("obj_chapter");
            if (chapter != null) {
                linkChap = chapter.getLink();
            }
            ;
        }
        webView = view.findViewById(R.id.wvChap);
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebChromeClient(new WebChromeClient());
        webView.setWebViewClient(new MyWebView());
        webView.loadUrl(linkChap);
        return view;

    }

    private class MyWebView extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;

        }
    }
}