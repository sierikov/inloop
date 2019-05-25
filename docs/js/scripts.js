!function (window, t) {
    "object" == typeof module && "object" == typeof module.exports
        ? module.exports = window.document ? t(window, !0)
        : function (e) {
            if (!e.document)
                throw new Error("jQuery requires a window with a document");
            return t(e)
        }
        : t(window)
}
(
    "undefined" != typeof window
        ? window
        : this,
    function (p, e) {
    var t = []
        , c = t.slice
        , m = t.concat
        , a = t.push
        , r = t.indexOf
        , n = {}
        , i = n.toString
        , g = n.hasOwnProperty
        , v = {}
        , y = p.document
        , o = "2.1.4"
        , T = function (e, t) {
        console.log(e);
        return new T.fn.init(e, t)
    }
        , s = /^[\s\uFEFF\xA0]+|[\s\uFEFF\xA0]+$/g
        , u = /^-ms-/
        , l = /-([\da-z])/gi
        , d = function (e, t) {
        return t.toUpperCase()
    };

    function h(e) {
        var t = "length" in e && e.length
            , n = T.type(e);
        return "function" !== n && !T.isWindow(e) && (!(1 !== e.nodeType || !t) || ("array" === n || 0 === t || "number" == typeof t && 0 < t && t - 1 in e))
    }

    T.fn = T.prototype = {
        jquery: o,
        constructor: T,
        selector: "",
        length: 0,
        toArray: function () {
            return c.call(this)
        },
        get: function (e) {
            return null != e ? e < 0 ? this[e + this.length] : this[e] : c.call(this)
        },
        pushStack: function (e) {
            var t = T.merge(this.constructor(), e);
            return t.prevObject = this,
                t.context = this.context,
                t
        },
        each: function (e, t) {
            return T.each(this, e, t)
        },
        map: function (n) {
            return this.pushStack(T.map(this, function (e, t) {
                return n.call(e, t, e)
            }))
        },
        slice: function () {
            return this.pushStack(c.apply(this, arguments))
        },
        first: function () {
            return this.eq(0)
        },
        last: function () {
            return this.eq(-1)
        },
        eq: function (e) {
            var t = this.length
                , n = +e + (e < 0 ? t : 0);
            return this.pushStack(0 <= n && n < t ? [this[n]] : [])
        },
        end: function () {
            return this.prevObject || this.constructor(null)
        },
        push: a,
        sort: t.sort,
        splice: t.splice
    },
        T.extend = T.fn.extend = function () {
            var e, t, n, i, r, o, s = arguments[0] || {}, a = 1, u = arguments.length, l = !1;
            for ("boolean" == typeof s && (l = s,
                s = arguments[a] || {},
                a++),
                 "object" == typeof s || T.isFunction(s) || (s = {}),
                 a === u && (s = this,
                     a--); a < u; a++)
                if (null != (e = arguments[a]))
                    for (t in e)
                        n = s[t],
                        s !== (i = e[t]) && (l && i && (T.isPlainObject(i) || (r = T.isArray(i))) ? (o = r ? (r = !1,
                            n && T.isArray(n) ? n : []) : n && T.isPlainObject(n) ? n : {},
                            s[t] = T.extend(l, o, i)) : void 0 !== i && (s[t] = i));
            return s
        }
        ,
        T.extend({
            expando: "jQuery" + (o + Math.random()).replace(/\D/g, ""),
            isReady: !0,
            error: function (e) {
                throw new Error(e)
            },
            noop: function () {
            },
            isFunction: function (e) {
                return "function" === T.type(e)
            },
            isArray: Array.isArray,
            isWindow: function (e) {
                return null != e && e === e.window
            },
            isNumeric: function (e) {
                return !T.isArray(e) && 0 <= e - parseFloat(e) + 1
            },
            isPlainObject: function (e) {
                return "object" === T.type(e) && !e.nodeType && !T.isWindow(e) && !(e.constructor && !g.call(e.constructor.prototype, "isPrototypeOf"))
            },
            isEmptyObject: function (e) {
                var t;
                for (t in e)
                    return !1;
                return !0
            },
            type: function (e) {
                return null == e ? e + "" : "object" == typeof e || "function" == typeof e ? n[i.call(e)] || "object" : typeof e
            },
            globalEval: function (e) {
                var t, n = eval;
                (e = T.trim(e)) && (1 === e.indexOf("use strict") ? ((t = y.createElement("script")).text = e,
                    y.head.appendChild(t).parentNode.removeChild(t)) : n(e))
            },
            camelCase: function (e) {
                return e.replace(u, "ms-").replace(l, d)
            },
            nodeName: function (e, t) {
                return e.nodeName && e.nodeName.toLowerCase() === t.toLowerCase()
            },
            each: function (e, t, n) {
                var i = 0
                    , r = e.length
                    , o = h(e);
                if (n) {
                    if (o)
                        for (; i < r && !1 !== t.apply(e[i], n); i++)
                            ;
                    else
                        for (i in e)
                            if (!1 === t.apply(e[i], n))
                                break
                } else if (o)
                    for (; i < r && !1 !== t.call(e[i], i, e[i]); i++)
                        ;
                else
                    for (i in e)
                        if (!1 === t.call(e[i], i, e[i]))
                            break;
                return e
            },
            trim: function (e) {
                return null == e ? "" : (e + "").replace(s, "")
            },
            makeArray: function (e, t) {
                var n = t || [];
                return null != e && (h(Object(e)) ? T.merge(n, "string" == typeof e ? [e] : e) : a.call(n, e)),
                    n
            },
            inArray: function (e, t, n) {
                return null == t ? -1 : r.call(t, e, n)
            },
            merge: function (e, t) {
                for (var n = +t.length, i = 0, r = e.length; i < n; i++)
                    e[r++] = t[i];
                return e.length = r,
                    e
            },
            grep: function (e, t, n) {
                for (var i = [], r = 0, o = e.length, s = !n; r < o; r++)
                    !t(e[r], r) !== s && i.push(e[r]);
                return i
            },
            map: function (e, t, n) {
                var i, r = 0, o = e.length, s = [];
                if (h(e))
                    for (; r < o; r++)
                        null != (i = t(e[r], r, n)) && s.push(i);
                else
                    for (r in e)
                        null != (i = t(e[r], r, n)) && s.push(i);
                return m.apply([], s)
            },
            guid: 1,
            proxy: function (e, t) {
                var n, i, r;
                return "string" == typeof t && (n = e[t],
                    t = e,
                    e = n),
                    T.isFunction(e) ? (i = c.call(arguments, 2),
                        (r = function () {
                                return e.apply(t || this, i.concat(c.call(arguments)))
                            }
                        ).guid = e.guid = e.guid || T.guid++,
                        r) : void 0
            },
            now: Date.now,
            support: v
        }),
        T.each("Boolean Number String Function Array Date RegExp Object Error".split(" "), function (e, t) {
            n["[object " + t + "]"] = t.toLowerCase()
        });
    var f = function (n) {
        var e, p, x, o, i, m, d, g, w, l, c, v, C, r, y, b, s, a, T, E = "sizzle" + 1 * new Date, k = n.document, S = 0,
            h = 0, u = oe(), f = oe(), I = oe(), L = function (e, t) {
                return e === t && (c = !0),
                    0
            }, N = {}.hasOwnProperty, t = [], A = t.pop, _ = t.push, j = t.push, q = t.slice, O = function (e, t) {
                for (var n = 0, i = e.length; n < i; n++)
                    if (e[n] === t)
                        return n;
                return -1
            },
            states = "checked|selected|async|autofocus|autoplay|controls|defer|disabled|hidden|ismap|loop|multiple|open|readonly|required|scoped",
            removeTerminates = "[\\x20\\t\\r\\n\\f]",
            dom = "(?:\\\\.|[\\w-]|[^\\x00-\\xa0])+",
            M = dom.replace("w", "w#"),
            F = "\\[" + removeTerminates + "*(" + dom + ")(?:" + removeTerminates + "*([*^$|!~]?=)" + removeTerminates + "*(?:'((?:\\\\.|[^\\\\'])*)'|\"((?:\\\\.|[^\\\\\"])*)\"|(" + M + "))|)" + removeTerminates + "*\\]",
            H = ":(" + dom + ")(?:\\((('((?:\\\\.|[^\\\\'])*)'|\"((?:\\\\.|[^\\\\\"])*)\")|((?:\\\\.|[^\\\\()[\\]]|" + F + ")*)|.*)\\)|)",
            R = new RegExp(removeTerminates + "+", "g"), $ = new RegExp("^" + removeTerminates + "+|((?:^|[^\\\\])(?:\\\\.)*)" + removeTerminates + "+$", "g"),
            W = new RegExp("^" + removeTerminates + "*," + removeTerminates + "*"), B = new RegExp("^" + removeTerminates + "*([>+~]|" + removeTerminates + ")" + removeTerminates + "*"),
            U = new RegExp("=" + removeTerminates + "*([^\\]'\"]*?)" + removeTerminates + "*\\]", "g"), Y = new RegExp(H),
            X = new RegExp("^" + M + "$"), V = {
                ID: new RegExp("^#(" + dom + ")"),
                CLASS: new RegExp("^\\.(" + dom + ")"),
                TAG: new RegExp("^(" + dom.replace("w", "w*") + ")"),
                ATTR: new RegExp("^" + F),
                PSEUDO: new RegExp("^" + H),
                CHILD: new RegExp("^:(only|first|last|nth|nth-last)-(child|of-type)(?:\\(" + removeTerminates + "*(even|odd|(([+-]|)(\\d*)n|)" + removeTerminates + "*(?:([+-]|)" + removeTerminates + "*(\\d+)|))" + removeTerminates + "*\\)|)", "i"),
                bool: new RegExp("^(?:" + states + ")$", "i"),
                needsContext: new RegExp("^" + removeTerminates + "*[>+~]|:(even|odd|eq|gt|lt|nth|first|last)(?:\\(" + removeTerminates + "*((?:-\\d)?\\d*)" + removeTerminates + "*\\)|)(?=[^-]|$)", "i")
            }, Q = /^(?:input|select|textarea|button)$/i, G = /^h\d$/i, Z = /^[^{]+\{\s*\[native \w/,
            K = /^(?:#([\w-]+)|(\w+)|\.([\w-]+))$/, J = /[+~]/, ee = /'|\\/g,
            te = new RegExp("\\\\([\\da-f]{1,6}" + removeTerminates + "?|(" + removeTerminates + ")|.)", "ig"), ne = function (e, t, n) {
                var i = "0x" + t - 65536;
                return i != i || n ? t : i < 0 ? String.fromCharCode(i + 65536) : String.fromCharCode(i >> 10 | 55296, 1023 & i | 56320)
            }, ie = function () {
                v()
            };
        try {
            j.apply(t = q.call(k.childNodes), k.childNodes),
                t[k.childNodes.length].nodeType
        } catch (e) {
            j = {
                apply: t.length ? function (e, t) {
                        _.apply(e, q.call(t))
                    }
                    : function (e, t) {
                        for (var n = e.length, i = 0; e[n++] = t[i++];)
                            ;
                        e.length = n - 1
                    }
            }
        }

        function re(e, t, n, i) {
            var r, o, s, a, u, l, c, d, h, f;
            if ((t ? t.ownerDocument || t : k) !== C && v(t),
                n = n || [],
                a = (t = t || C).nodeType,
            "string" != typeof e || !e || 1 !== a && 9 !== a && 11 !== a)
                return n;
            if (!i && y) {
                if (11 !== a && (r = K.exec(e)))
                    if (s = r[1]) {
                        if (9 === a) {
                            if (!(o = t.getElementById(s)) || !o.parentNode)
                                return n;
                            if (o.id === s)
                                return n.push(o),
                                    n
                        } else if (t.ownerDocument && (o = t.ownerDocument.getElementById(s)) && T(t, o) && o.id === s)
                            return n.push(o),
                                n
                    } else {
                        if (r[2])
                            return j.apply(n, t.getElementsByTagName(e)),
                                n;
                        if ((s = r[3]) && p.getElementsByClassName)
                            return j.apply(n, t.getElementsByClassName(s)),
                                n
                    }
                if (p.qsa && (!b || !b.test(e))) {
                    if (d = c = E,
                        h = t,
                        f = 1 !== a && e,
                    1 === a && "object" !== t.nodeName.toLowerCase()) {
                        for (l = m(e),
                                 (c = t.getAttribute("id")) ? d = c.replace(ee, "\\$&") : t.setAttribute("id", d),
                                 d = "[id='" + d + "'] ",
                                 u = l.length; u--;)
                            l[u] = d + me(l[u]);
                        h = J.test(e) && fe(t.parentNode) || t,
                            f = l.join(",")
                    }
                    if (f)
                        try {
                            return j.apply(n, h.querySelectorAll(f)),
                                n
                        } catch (e) {
                        } finally {
                            c || t.removeAttribute("id")
                        }
                }
            }
            return g(e.replace($, "$1"), t, n, i)
        }

        function oe() {
            var i = [];
            return function e(t, n) {
                return i.push(t + " ") > x.cacheLength && delete e[i.shift()],
                    e[t + " "] = n
            }
        }

        function se(e) {
            return e[E] = !0,
                e
        }

        function ae(e) {
            var t = C.createElement("div");
            try {
                return !!e(t)
            } catch (e) {
                return !1
            } finally {
                t.parentNode && t.parentNode.removeChild(t),
                    t = null
            }
        }

        function ue(e, t) {
            for (var n = e.split("|"), i = e.length; i--;)
                x.attrHandle[n[i]] = t
        }

        function le(e, t) {
            var n = t && e
                ,
                i = n && 1 === e.nodeType && 1 === t.nodeType && (~t.sourceIndex || 1 << 31) - (~e.sourceIndex || 1 << 31);
            if (i)
                return i;
            if (n)
                for (; n = n.nextSibling;)
                    if (n === t)
                        return -1;
            return e ? 1 : -1
        }

        function ce(t) {
            return function (e) {
                return "input" === e.nodeName.toLowerCase() && e.type === t
            }
        }

        function de(n) {
            return function (e) {
                var t = e.nodeName.toLowerCase();
                return ("input" === t || "button" === t) && e.type === n
            }
        }

        function he(s) {
            return se(function (o) {
                return o = +o,
                    se(function (e, t) {
                        for (var n, i = s([], e.length, o), r = i.length; r--;)
                            e[n = i[r]] && (e[n] = !(t[n] = e[n]))
                    })
            })
        }

        function fe(e) {
            return e && void 0 !== e.getElementsByTagName && e
        }

        for (e in p = re.support = {},
            i = re.isXML = function (e) {
                var t = e && (e.ownerDocument || e).documentElement;
                return !!t && "HTML" !== t.nodeName
            }
            ,
            v = re.setDocument = function (e) {
                var t, n, u = e ? e.ownerDocument || e : k;
                return u !== C && 9 === u.nodeType && u.documentElement ? (r = (C = u).documentElement,
                (n = u.defaultView) && n !== n.top && (n.addEventListener ? n.addEventListener("unload", ie, !1) : n.attachEvent && n.attachEvent("onunload", ie)),
                    y = !i(u),
                    p.attributes = ae(function (e) {
                        return e.className = "i",
                            !e.getAttribute("className")
                    }),
                    p.getElementsByTagName = ae(function (e) {
                        return e.appendChild(u.createComment("")),
                            !e.getElementsByTagName("*").length
                    }),
                    p.getElementsByClassName = Z.test(u.getElementsByClassName),
                    p.getById = ae(function (e) {
                        return r.appendChild(e).id = E,
                        !u.getElementsByName || !u.getElementsByName(E).length
                    }),
                    p.getById ? (x.find.ID = function (e, t) {
                            if (void 0 !== t.getElementById && y) {
                                var n = t.getElementById(e);
                                return n && n.parentNode ? [n] : []
                            }
                        }
                            ,
                            x.filter.ID = function (e) {
                                var t = e.replace(te, ne);
                                return function (e) {
                                    return e.getAttribute("id") === t
                                }
                            }
                    ) : (delete x.find.ID,
                            x.filter.ID = function (e) {
                                var n = e.replace(te, ne);
                                return function (e) {
                                    var t = void 0 !== e.getAttributeNode && e.getAttributeNode("id");
                                    return t && t.value === n
                                }
                            }
                    ),
                    x.find.TAG = p.getElementsByTagName ? function (e, t) {
                            return void 0 !== t.getElementsByTagName ? t.getElementsByTagName(e) : p.qsa ? t.querySelectorAll(e) : void 0
                        }
                        : function (e, t) {
                            var n, i = [], r = 0, o = t.getElementsByTagName(e);
                            if ("*" !== e)
                                return o;
                            for (; n = o[r++];)
                                1 === n.nodeType && i.push(n);
                            return i
                        }
                    ,
                    x.find.CLASS = p.getElementsByClassName && function (e, t) {
                        return y ? t.getElementsByClassName(e) : void 0
                    }
                    ,
                    s = [],
                    b = [],
                (p.qsa = Z.test(u.querySelectorAll)) && (ae(function (e) {
                    r.appendChild(e).innerHTML = "<a id='" + E + "'></a><select id='" + E + "-\f]' msallowcapture=''><option selected=''></option></select>",
                    e.querySelectorAll("[msallowcapture^='']").length && b.push("[*^$]=" + removeTerminates + "*(?:''|\"\")"),
                    e.querySelectorAll("[selected]").length || b.push("\\[" + removeTerminates + "*(?:value|" + states + ")"),
                    e.querySelectorAll("[id~=" + E + "-]").length || b.push("~="),
                    e.querySelectorAll(":checked").length || b.push(":checked"),
                    e.querySelectorAll("a#" + E + "+*").length || b.push(".#.+[+~]")
                }),
                    ae(function (e) {
                        var t = u.createElement("input");
                        t.setAttribute("type", "hidden"),
                            e.appendChild(t).setAttribute("name", "D"),
                        e.querySelectorAll("[name=d]").length && b.push("name" + removeTerminates + "*[*^$|!~]?="),
                        e.querySelectorAll(":enabled").length || b.push(":enabled", ":disabled"),
                            e.querySelectorAll("*,:x"),
                            b.push(",.*:")
                    })),
                (p.matchesSelector = Z.test(a = r.matches || r.webkitMatchesSelector || r.mozMatchesSelector || r.oMatchesSelector || r.msMatchesSelector)) && ae(function (e) {
                    p.disconnectedMatch = a.call(e, "div"),
                        a.call(e, "[s!='']:x"),
                        s.push("!=", H)
                }),
                    b = b.length && new RegExp(b.join("|")),
                    s = s.length && new RegExp(s.join("|")),
                    t = Z.test(r.compareDocumentPosition),
                    T = t || Z.test(r.contains) ? function (e, t) {
                            var n = 9 === e.nodeType ? e.documentElement : e
                                , i = t && t.parentNode;
                            return e === i || !(!i || 1 !== i.nodeType || !(n.contains ? n.contains(i) : e.compareDocumentPosition && 16 & e.compareDocumentPosition(i)))
                        }
                        : function (e, t) {
                            if (t)
                                for (; t = t.parentNode;)
                                    if (t === e)
                                        return !0;
                            return !1
                        }
                    ,
                    L = t ? function (e, t) {
                            if (e === t)
                                return c = !0,
                                    0;
                            var n = !e.compareDocumentPosition - !t.compareDocumentPosition;
                            return n || (1 & (n = (e.ownerDocument || e) === (t.ownerDocument || t) ? e.compareDocumentPosition(t) : 1) || !p.sortDetached && t.compareDocumentPosition(e) === n ? e === u || e.ownerDocument === k && T(k, e) ? -1 : t === u || t.ownerDocument === k && T(k, t) ? 1 : l ? O(l, e) - O(l, t) : 0 : 4 & n ? -1 : 1)
                        }
                        : function (e, t) {
                            if (e === t)
                                return c = !0,
                                    0;
                            var n, i = 0, r = e.parentNode, o = t.parentNode, s = [e], a = [t];
                            if (!r || !o)
                                return e === u ? -1 : t === u ? 1 : r ? -1 : o ? 1 : l ? O(l, e) - O(l, t) : 0;
                            if (r === o)
                                return le(e, t);
                            for (n = e; n = n.parentNode;)
                                s.unshift(n);
                            for (n = t; n = n.parentNode;)
                                a.unshift(n);
                            for (; s[i] === a[i];)
                                i++;
                            return i ? le(s[i], a[i]) : s[i] === k ? -1 : a[i] === k ? 1 : 0
                        }
                    ,
                    u) : C
            }
            ,
            re.matches = function (e, t) {
                return re(e, null, null, t)
            }
            ,
            re.matchesSelector = function (e, t) {
                if ((e.ownerDocument || e) !== C && v(e),
                    t = t.replace(U, "='$1']"),
                    !(!p.matchesSelector || !y || s && s.test(t) || b && b.test(t)))
                    try {
                        var n = a.call(e, t);
                        if (n || p.disconnectedMatch || e.document && 11 !== e.document.nodeType)
                            return n
                    } catch (e) {
                    }
                return 0 < re(t, C, null, [e]).length
            }
            ,
            re.contains = function (e, t) {
                return (e.ownerDocument || e) !== C && v(e),
                    T(e, t)
            }
            ,
            re.attr = function (e, t) {
                (e.ownerDocument || e) !== C && v(e);
                var n = x.attrHandle[t.toLowerCase()]
                    , i = n && N.call(x.attrHandle, t.toLowerCase()) ? n(e, t, !y) : void 0;
                return void 0 !== i ? i : p.attributes || !y ? e.getAttribute(t) : (i = e.getAttributeNode(t)) && i.specified ? i.value : null
            }
            ,
            re.error = function (e) {
                throw new Error("Syntax error, unrecognized expression: " + e)
            }
            ,
            re.uniqueSort = function (e) {
                var t, n = [], i = 0, r = 0;
                if (c = !p.detectDuplicates,
                    l = !p.sortStable && e.slice(0),
                    e.sort(L),
                    c) {
                    for (; t = e[r++];)
                        t === e[r] && (i = n.push(r));
                    for (; i--;)
                        e.splice(n[i], 1)
                }
                return l = null,
                    e
            }
            ,
            o = re.getText = function (e) {
                var t, n = "", i = 0, r = e.nodeType;
                if (r) {
                    if (1 === r || 9 === r || 11 === r) {
                        if ("string" == typeof e.textContent)
                            return e.textContent;
                        for (e = e.firstChild; e; e = e.nextSibling)
                            n += o(e)
                    } else if (3 === r || 4 === r)
                        return e.nodeValue
                } else
                    for (; t = e[i++];)
                        n += o(t);
                return n
            }
            ,
            (x = re.selectors = {
                cacheLength: 50,
                createPseudo: se,
                match: V,
                attrHandle: {},
                find: {},
                relative: {
                    ">": {
                        dir: "parentNode",
                        first: !0
                    },
                    " ": {
                        dir: "parentNode"
                    },
                    "+": {
                        dir: "previousSibling",
                        first: !0
                    },
                    "~": {
                        dir: "previousSibling"
                    }
                },
                preFilter: {
                    ATTR: function (e) {
                        return e[1] = e[1].replace(te, ne),
                            e[3] = (e[3] || e[4] || e[5] || "").replace(te, ne),
                        "~=" === e[2] && (e[3] = " " + e[3] + " "),
                            e.slice(0, 4)
                    },
                    CHILD: function (e) {
                        return e[1] = e[1].toLowerCase(),
                            "nth" === e[1].slice(0, 3) ? (e[3] || re.error(e[0]),
                                e[4] = +(e[4] ? e[5] + (e[6] || 1) : 2 * ("even" === e[3] || "odd" === e[3])),
                                e[5] = +(e[7] + e[8] || "odd" === e[3])) : e[3] && re.error(e[0]),
                            e
                    },
                    PSEUDO: function (e) {
                        var t, n = !e[6] && e[2];
                        return V.CHILD.test(e[0]) ? null : (e[3] ? e[2] = e[4] || e[5] || "" : n && Y.test(n) && (t = m(n, !0)) && (t = n.indexOf(")", n.length - t) - n.length) && (e[0] = e[0].slice(0, t),
                            e[2] = n.slice(0, t)),
                            e.slice(0, 3))
                    }
                },
                filter: {
                    TAG: function (e) {
                        var t = e.replace(te, ne).toLowerCase();
                        return "*" === e ? function () {
                                return !0
                            }
                            : function (e) {
                                return e.nodeName && e.nodeName.toLowerCase() === t
                            }
                    },
                    CLASS: function (e) {
                        var t = u[e + " "];
                        return t || (t = new RegExp("(^|" + removeTerminates + ")" + e + "(" + removeTerminates + "|$)")) && u(e, function (e) {
                            return t.test("string" == typeof e.className && e.className || void 0 !== e.getAttribute && e.getAttribute("class") || "")
                        })
                    },
                    ATTR: function (n, i, r) {
                        return function (e) {
                            var t = re.attr(e, n);
                            return null == t ? "!=" === i : !i || (t += "",
                                "=" === i ? t === r : "!=" === i ? t !== r : "^=" === i ? r && 0 === t.indexOf(r) : "*=" === i ? r && -1 < t.indexOf(r) : "$=" === i ? r && t.slice(-r.length) === r : "~=" === i ? -1 < (" " + t.replace(R, " ") + " ").indexOf(r) : "|=" === i && (t === r || t.slice(0, r.length + 1) === r + "-"))
                        }
                    },
                    CHILD: function (f, e, t, p, m) {
                        var g = "nth" !== f.slice(0, 3)
                            , v = "last" !== f.slice(-4)
                            , y = "of-type" === e;
                        return 1 === p && 0 === m ? function (e) {
                                return !!e.parentNode
                            }
                            : function (e, t, n) {
                                var i, r, o, s, a, u, l = g !== v ? "nextSibling" : "previousSibling", c = e.parentNode,
                                    d = y && e.nodeName.toLowerCase(), h = !n && !y;
                                if (c) {
                                    if (g) {
                                        for (; l;) {
                                            for (o = e; o = o[l];)
                                                if (y ? o.nodeName.toLowerCase() === d : 1 === o.nodeType)
                                                    return !1;
                                            u = l = "only" === f && !u && "nextSibling"
                                        }
                                        return !0
                                    }
                                    if (u = [v ? c.firstChild : c.lastChild],
                                    v && h) {
                                        for (a = (i = (r = c[E] || (c[E] = {}))[f] || [])[0] === S && i[1],
                                                 s = i[0] === S && i[2],
                                                 o = a && c.childNodes[a]; o = ++a && o && o[l] || (s = a = 0) || u.pop();)
                                            if (1 === o.nodeType && ++s && o === e) {
                                                r[f] = [S, a, s];
                                                break
                                            }
                                    } else if (h && (i = (e[E] || (e[E] = {}))[f]) && i[0] === S)
                                        s = i[1];
                                    else
                                        for (; (o = ++a && o && o[l] || (s = a = 0) || u.pop()) && ((y ? o.nodeName.toLowerCase() !== d : 1 !== o.nodeType) || !++s || (h && ((o[E] || (o[E] = {}))[f] = [S, s]),
                                        o !== e));)
                                            ;
                                    return (s -= m) === p || s % p == 0 && 0 <= s / p
                                }
                            }
                    },
                    PSEUDO: function (e, o) {
                        var t,
                            s = x.pseudos[e] || x.setFilters[e.toLowerCase()] || re.error("unsupported pseudo: " + e);
                        return s[E] ? s(o) : 1 < s.length ? (t = [e, e, "", o],
                                x.setFilters.hasOwnProperty(e.toLowerCase()) ? se(function (e, t) {
                                    for (var n, i = s(e, o), r = i.length; r--;)
                                        e[n = O(e, i[r])] = !(t[n] = i[r])
                                }) : function (e) {
                                    return s(e, 0, t)
                                }
                        ) : s
                    }
                },
                pseudos: {
                    not: se(function (e) {
                        var i = []
                            , r = []
                            , a = d(e.replace($, "$1"));
                        return a[E] ? se(function (e, t, n, i) {
                            for (var r, o = a(e, null, i, []), s = e.length; s--;)
                                (r = o[s]) && (e[s] = !(t[s] = r))
                        }) : function (e, t, n) {
                            return i[0] = e,
                                a(i, null, n, r),
                                i[0] = null,
                                !r.pop()
                        }
                    }),
                    has: se(function (t) {
                        return function (e) {
                            return 0 < re(t, e).length
                        }
                    }),
                    contains: se(function (t) {
                        return t = t.replace(te, ne),
                            function (e) {
                                return -1 < (e.textContent || e.innerText || o(e)).indexOf(t)
                            }
                    }),
                    lang: se(function (n) {
                        return X.test(n || "") || re.error("unsupported lang: " + n),
                            n = n.replace(te, ne).toLowerCase(),
                            function (e) {
                                var t;
                                do {
                                    if (t = y ? e.lang : e.getAttribute("xml:lang") || e.getAttribute("lang"))
                                        return (t = t.toLowerCase()) === n || 0 === t.indexOf(n + "-")
                                } while ((e = e.parentNode) && 1 === e.nodeType);
                                return !1
                            }
                    }),
                    target: function (e) {
                        var t = n.location && n.location.hash;
                        return t && t.slice(1) === e.id
                    },
                    root: function (e) {
                        return e === r
                    },
                    focus: function (e) {
                        return e === C.activeElement && (!C.hasFocus || C.hasFocus()) && !!(e.type || e.href || ~e.tabIndex)
                    },
                    enabled: function (e) {
                        return !1 === e.disabled
                    },
                    disabled: function (e) {
                        return !0 === e.disabled
                    },
                    checked: function (e) {
                        var t = e.nodeName.toLowerCase();
                        return "input" === t && !!e.checked || "option" === t && !!e.selected
                    },
                    selected: function (e) {
                        return e.parentNode && e.parentNode.selectedIndex,
                        !0 === e.selected
                    },
                    empty: function (e) {
                        for (e = e.firstChild; e; e = e.nextSibling)
                            if (e.nodeType < 6)
                                return !1;
                        return !0
                    },
                    parent: function (e) {
                        return !x.pseudos.empty(e)
                    },
                    header: function (e) {
                        return G.test(e.nodeName)
                    },
                    input: function (e) {
                        return Q.test(e.nodeName)
                    },
                    button: function (e) {
                        var t = e.nodeName.toLowerCase();
                        return "input" === t && "button" === e.type || "button" === t
                    },
                    text: function (e) {
                        var t;
                        return "input" === e.nodeName.toLowerCase() && "text" === e.type && (null == (t = e.getAttribute("type")) || "text" === t.toLowerCase())
                    },
                    first: he(function () {
                        return [0]
                    }),
                    last: he(function (e, t) {
                        return [t - 1]
                    }),
                    eq: he(function (e, t, n) {
                        return [n < 0 ? n + t : n]
                    }),
                    even: he(function (e, t) {
                        for (var n = 0; n < t; n += 2)
                            e.push(n);
                        return e
                    }),
                    odd: he(function (e, t) {
                        for (var n = 1; n < t; n += 2)
                            e.push(n);
                        return e
                    }),
                    lt: he(function (e, t, n) {
                        for (var i = n < 0 ? n + t : n; 0 <= --i;)
                            e.push(i);
                        return e
                    }),
                    gt: he(function (e, t, n) {
                        for (var i = n < 0 ? n + t : n; ++i < t;)
                            e.push(i);
                        return e
                    })
                }
            }).pseudos.nth = x.pseudos.eq,
            {
                radio: !0,
                checkbox: !0,
                file: !0,
                password: !0,
                image: !0
            })
            x.pseudos[e] = ce(e);
        for (e in {
            submit: !0,
            reset: !0
        })
            x.pseudos[e] = de(e);

        function pe() {
        }

        function me(e) {
            for (var t = 0, n = e.length, i = ""; t < n; t++)
                i += e[t].value;
            return i
        }

        function ge(s, e, t) {
            var a = e.dir
                , u = t && "parentNode" === a
                , l = h++;
            return e.first ? function (e, t, n) {
                    for (; e = e[a];)
                        if (1 === e.nodeType || u)
                            return s(e, t, n)
                }
                : function (e, t, n) {
                    var i, r, o = [S, l];
                    if (n) {
                        for (; e = e[a];)
                            if ((1 === e.nodeType || u) && s(e, t, n))
                                return !0
                    } else
                        for (; e = e[a];)
                            if (1 === e.nodeType || u) {
                                if ((i = (r = e[E] || (e[E] = {}))[a]) && i[0] === S && i[1] === l)
                                    return o[2] = i[2];
                                if ((r[a] = o)[2] = s(e, t, n))
                                    return !0
                            }
                }
        }

        function ve(r) {
            return 1 < r.length ? function (e, t, n) {
                    for (var i = r.length; i--;)
                        if (!r[i](e, t, n))
                            return !1;
                    return !0
                }
                : r[0]
        }

        function ye(e, t, n, i, r) {
            for (var o, s = [], a = 0, u = e.length, l = null != t; a < u; a++)
                (o = e[a]) && (!n || n(o, i, r)) && (s.push(o),
                l && t.push(a));
            return s
        }

        function be(f, p, m, g, v, e) {
            return g && !g[E] && (g = be(g)),
            v && !v[E] && (v = be(v, e)),
                se(function (e, t, n, i) {
                    var r, o, s, a = [], u = [], l = t.length, c = e || function (e, t, n) {
                            for (var i = 0, r = t.length; i < r; i++)
                                re(e, t[i], n);
                            return n
                        }(p || "*", n.nodeType ? [n] : n, []), d = !f || !e && p ? c : ye(c, a, f, n, i),
                        h = m ? v || (e ? f : l || g) ? [] : t : d;
                    if (m && m(d, h, n, i),
                        g)
                        for (r = ye(h, u),
                                 g(r, [], n, i),
                                 o = r.length; o--;)
                            (s = r[o]) && (h[u[o]] = !(d[u[o]] = s));
                    if (e) {
                        if (v || f) {
                            if (v) {
                                for (r = [],
                                         o = h.length; o--;)
                                    (s = h[o]) && r.push(d[o] = s);
                                v(null, h = [], r, i)
                            }
                            for (o = h.length; o--;)
                                (s = h[o]) && -1 < (r = v ? O(e, s) : a[o]) && (e[r] = !(t[r] = s))
                        }
                    } else
                        h = ye(h === t ? h.splice(l, h.length) : h),
                            v ? v(null, t, h, i) : j.apply(t, h)
                })
        }

        function xe(e) {
            for (var r, t, n, i = e.length, o = x.relative[e[0].type], s = o || x.relative[" "], a = o ? 1 : 0, u = ge(function (e) {
                return e === r
            }, s, !0), l = ge(function (e) {
                return -1 < O(r, e)
            }, s, !0), c = [function (e, t, n) {
                var i = !o && (n || t !== w) || ((r = t).nodeType ? u(e, t, n) : l(e, t, n));
                return r = null,
                    i
            }
            ]; a < i; a++)
                if (t = x.relative[e[a].type])
                    c = [ge(ve(c), t)];
                else {
                    if ((t = x.filter[e[a].type].apply(null, e[a].matches))[E]) {
                        for (n = ++a; n < i && !x.relative[e[n].type]; n++)
                            ;
                        return be(1 < a && ve(c), 1 < a && me(e.slice(0, a - 1).concat({
                            value: " " === e[a - 2].type ? "*" : ""
                        })).replace($, "$1"), t, a < n && xe(e.slice(a, n)), n < i && xe(e = e.slice(n)), n < i && me(e))
                    }
                    c.push(t)
                }
            return ve(c)
        }

        return pe.prototype = x.filters = x.pseudos,
            x.setFilters = new pe,
            m = re.tokenize = function (e, t) {
                var n, i, r, o, s, a, u, l = f[e + " "];
                if (l)
                    return t ? 0 : l.slice(0);
                for (s = e,
                         a = [],
                         u = x.preFilter; s;) {
                    for (o in (!n || (i = W.exec(s))) && (i && (s = s.slice(i[0].length) || s),
                        a.push(r = [])),
                        n = !1,
                    (i = B.exec(s)) && (n = i.shift(),
                        r.push({
                            value: n,
                            type: i[0].replace($, " ")
                        }),
                        s = s.slice(n.length)),
                        x.filter)
                        !(i = V[o].exec(s)) || u[o] && !(i = u[o](i)) || (n = i.shift(),
                            r.push({
                                value: n,
                                type: o,
                                matches: i
                            }),
                            s = s.slice(n.length));
                    if (!n)
                        break
                }
                return t ? s.length : s ? re.error(e) : f(e, a).slice(0)
            }
            ,
            d = re.compile = function (e, t) {
                var n, g, v, y, b, i, r = [], o = [], s = I[e + " "];
                if (!s) {
                    for (t || (t = m(e)),
                             n = t.length; n--;)
                        (s = xe(t[n]))[E] ? r.push(s) : o.push(s);
                    (s = I(e, (g = o,
                        y = 0 < (v = r).length,
                        b = 0 < g.length,
                        i = function (e, t, n, i, r) {
                            var o, s, a, u = 0, l = "0", c = e && [], d = [], h = w, f = e || b && x.find.TAG("*", r),
                                p = S += null == h ? 1 : Math.random() || .1, m = f.length;
                            for (r && (w = t !== C && t); l !== m && null != (o = f[l]); l++) {
                                if (b && o) {
                                    for (s = 0; a = g[s++];)
                                        if (a(o, t, n)) {
                                            i.push(o);
                                            break
                                        }
                                    r && (S = p)
                                }
                                y && ((o = !a && o) && u--,
                                e && c.push(o))
                            }
                            if (u += l,
                            y && l !== u) {
                                for (s = 0; a = v[s++];)
                                    a(c, d, t, n);
                                if (e) {
                                    if (0 < u)
                                        for (; l--;)
                                            c[l] || d[l] || (d[l] = A.call(i));
                                    d = ye(d)
                                }
                                j.apply(i, d),
                                r && !e && 0 < d.length && 1 < u + v.length && re.uniqueSort(i)
                            }
                            return r && (S = p,
                                w = h),
                                c
                        }
                        ,
                        y ? se(i) : i))).selector = e
                }
                return s
            }
            ,
            g = re.select = function (e, t, n, i) {
                var r, o, s, a, u, l = "function" == typeof e && e, c = !i && m(e = l.selector || e);
                if (n = n || [],
                1 === c.length) {
                    if (2 < (o = c[0] = c[0].slice(0)).length && "ID" === (s = o[0]).type && p.getById && 9 === t.nodeType && y && x.relative[o[1].type]) {
                        if (!(t = (x.find.ID(s.matches[0].replace(te, ne), t) || [])[0]))
                            return n;
                        l && (t = t.parentNode),
                            e = e.slice(o.shift().value.length)
                    }
                    for (r = V.needsContext.test(e) ? 0 : o.length; r-- && (s = o[r],
                        !x.relative[a = s.type]);)
                        if ((u = x.find[a]) && (i = u(s.matches[0].replace(te, ne), J.test(o[0].type) && fe(t.parentNode) || t))) {
                            if (o.splice(r, 1),
                                !(e = i.length && me(o)))
                                return j.apply(n, i),
                                    n;
                            break
                        }
                }
                return (l || d(e, c))(i, t, !y, n, J.test(e) && fe(t.parentNode) || t),
                    n
            }
            ,
            p.sortStable = E.split("").sort(L).join("") === E,
            p.detectDuplicates = !!c,
            v(),
            p.sortDetached = ae(function (e) {
                return 1 & e.compareDocumentPosition(C.createElement("div"))
            }),
        ae(function (e) {
            return e.innerHTML = "<a href='#'></a>",
            "#" === e.firstChild.getAttribute("href")
        }) || ue("type|href|height|width", function (e, t, n) {
            return n ? void 0 : e.getAttribute(t, "type" === t.toLowerCase() ? 1 : 2)
        }),
        p.attributes && ae(function (e) {
            return e.innerHTML = "<input/>",
                e.firstChild.setAttribute("value", ""),
            "" === e.firstChild.getAttribute("value")
        }) || ue("value", function (e, t, n) {
            return n || "input" !== e.nodeName.toLowerCase() ? void 0 : e.defaultValue
        }),
        ae(function (e) {
            return null == e.getAttribute("disabled")
        }) || ue(states, function (e, t, n) {
            var i;
            return n ? void 0 : !0 === e[t] ? t.toLowerCase() : (i = e.getAttributeNode(t)) && i.specified ? i.value : null
        }),
            re
    }(p);
    T.find = f,
        T.expr = f.selectors,
        T.expr[":"] = T.expr.pseudos,
        T.unique = f.uniqueSort,
        T.text = f.getText,
        T.isXMLDoc = f.isXML,
        T.contains = f.contains;
    var b = T.expr.match.needsContext
        , x = /^<(\w+)\s*\/?>(?:<\/\1>|)$/
        , w = /^.[^:#\[\.,]*$/;

    function C(e, n, i) {
        if (T.isFunction(n))
            return T.grep(e, function (e, t) {
                return !!n.call(e, t, e) !== i
            });
        if (n.nodeType)
            return T.grep(e, function (e) {
                return e === n !== i
            });
        if ("string" == typeof n) {
            if (w.test(n))
                return T.filter(n, e, i);
            n = T.filter(n, e)
        }
        return T.grep(e, function (e) {
            return 0 <= r.call(n, e) !== i
        })
    }

    T.filter = function (e, t, n) {
        var i = t[0];
        return n && (e = ":not(" + e + ")"),
            1 === t.length && 1 === i.nodeType ? T.find.matchesSelector(i, e) ? [i] : [] : T.find.matches(e, T.grep(t, function (e) {
                return 1 === e.nodeType
            }))
    }
        ,
        T.fn.extend({
            find: function (e) {
                var t, n = this.length, i = [], r = this;
                if ("string" != typeof e)
                    return this.pushStack(T(e).filter(function () {
                        for (t = 0; t < n; t++)
                            if (T.contains(r[t], this))
                                return !0
                    }));
                for (t = 0; t < n; t++)
                    T.find(e, r[t], i);
                return (i = this.pushStack(1 < n ? T.unique(i) : i)).selector = this.selector ? this.selector + " " + e : e,
                    i
            },
            filter: function (e) {
                return this.pushStack(C(this, e || [], !1))
            },
            not: function (e) {
                return this.pushStack(C(this, e || [], !0))
            },
            is: function (e) {
                return !!C(this, "string" == typeof e && b.test(e) ? T(e) : e || [], !1).length
            }
        });
    var E, k = /^(?:\s*(<[\w\W]+>)[^>]*|#([\w-]*))$/;
    (T.fn.init = function (e, t) {
            var n, i;
            if (!e)
                return this;
            if ("string" != typeof e)
                return e.nodeType ? (this.context = this[0] = e,
                    this.length = 1,
                    this) : T.isFunction(e) ? void 0 !== E.ready ? E.ready(e) : e(T) : (void 0 !== e.selector && (this.selector = e.selector,
                    this.context = e.context),
                    T.makeArray(e, this));
            if (!(n = "<" === e[0] && ">" === e[e.length - 1] && 3 <= e.length ? [null, e, null] : k.exec(e)) || !n[1] && t)
                return !t || t.jquery ? (t || E).find(e) : this.constructor(t).find(e);
            if (n[1]) {
                if (t = t instanceof T ? t[0] : t,
                    T.merge(this, T.parseHTML(n[1], t && t.nodeType ? t.ownerDocument || t : y, !0)),
                x.test(n[1]) && T.isPlainObject(t))
                    for (n in t)
                        T.isFunction(this[n]) ? this[n](t[n]) : this.attr(n, t[n]);
                return this
            }
            return (i = y.getElementById(n[2])) && i.parentNode && (this.length = 1,
                this[0] = i),
                this.context = y,
                this.selector = e,
                this
        }
    ).prototype = T.fn,
        E = T(y);
    var S = /^(?:parents|prev(?:Until|All))/
        , I = {
        children: !0,
        contents: !0,
        next: !0,
        prev: !0
    };

    function L(e, t) {
        for (; (e = e[t]) && 1 !== e.nodeType;)
            ;
        return e
    }

    T.extend({
        dir: function (e, t, n) {
            for (var i = [], r = void 0 !== n; (e = e[t]) && 9 !== e.nodeType;)
                if (1 === e.nodeType) {
                    if (r && T(e).is(n))
                        break;
                    i.push(e)
                }
            return i
        },
        sibling: function (e, t) {
            for (var n = []; e; e = e.nextSibling)
                1 === e.nodeType && e !== t && n.push(e);
            return n
        }
    }),
        T.fn.extend({
            has: function (e) {
                var t = T(e, this)
                    , n = t.length;
                return this.filter(function () {
                    for (var e = 0; e < n; e++)
                        if (T.contains(this, t[e]))
                            return !0
                })
            },
            closest: function (e, t) {
                for (var n, i = 0, r = this.length, o = [], s = b.test(e) || "string" != typeof e ? T(e, t || this.context) : 0; i < r; i++)
                    for (n = this[i]; n && n !== t; n = n.parentNode)
                        if (n.nodeType < 11 && (s ? -1 < s.index(n) : 1 === n.nodeType && T.find.matchesSelector(n, e))) {
                            o.push(n);
                            break
                        }
                return this.pushStack(1 < o.length ? T.unique(o) : o)
            },
            index: function (e) {
                return e ? "string" == typeof e ? r.call(T(e), this[0]) : r.call(this, e.jquery ? e[0] : e) : this[0] && this[0].parentNode ? this.first().prevAll().length : -1
            },
            add: function (e, t) {
                return this.pushStack(T.unique(T.merge(this.get(), T(e, t))))
            },
            addBack: function (e) {
                return this.add(null == e ? this.prevObject : this.prevObject.filter(e))
            }
        }),
        T.each({
            parent: function (e) {
                var t = e.parentNode;
                return t && 11 !== t.nodeType ? t : null
            },
            parents: function (e) {
                return T.dir(e, "parentNode")
            },
            parentsUntil: function (e, t, n) {
                return T.dir(e, "parentNode", n)
            },
            next: function (e) {
                return L(e, "nextSibling")
            },
            prev: function (e) {
                return L(e, "previousSibling")
            },
            nextAll: function (e) {
                return T.dir(e, "nextSibling")
            },
            prevAll: function (e) {
                return T.dir(e, "previousSibling")
            },
            nextUntil: function (e, t, n) {
                return T.dir(e, "nextSibling", n)
            },
            prevUntil: function (e, t, n) {
                return T.dir(e, "previousSibling", n)
            },
            siblings: function (e) {
                return T.sibling((e.parentNode || {}).firstChild, e)
            },
            children: function (e) {
                return T.sibling(e.firstChild)
            },
            contents: function (e) {
                return e.contentDocument || T.merge([], e.childNodes)
            }
        }, function (i, r) {
            T.fn[i] = function (e, t) {
                var n = T.map(this, r, e);
                return "Until" !== i.slice(-5) && (t = e),
                t && "string" == typeof t && (n = T.filter(t, n)),
                1 < this.length && (I[i] || T.unique(n),
                S.test(i) && n.reverse()),
                    this.pushStack(n)
            }
        });
    var N, A = /\S+/g, _ = {};

    function j() {
        y.removeEventListener("DOMContentLoaded", j, !1),
            p.removeEventListener("load", j, !1),
            T.ready()
    }

    T.Callbacks = function (r) {
        var e, n;
        r = "string" == typeof r ? _[r] || (n = _[e = r] = {},
            T.each(e.match(A) || [], function (e, t) {
                n[t] = !0
            }),
            n) : T.extend({}, r);
        var t, i, o, s, a, u, l = [], c = !r.once && [], d = function (e) {
            for (t = r.memory && e,
                     i = !0,
                     u = s || 0,
                     s = 0,
                     a = l.length,
                     o = !0; l && u < a; u++)
                if (!1 === l[u].apply(e[0], e[1]) && r.stopOnFalse) {
                    t = !1;
                    break
                }
            o = !1,
            l && (c ? c.length && d(c.shift()) : t ? l = [] : h.disable())
        }, h = {
            add: function () {
                if (l) {
                    var e = l.length;
                    !function i(e) {
                        T.each(e, function (e, t) {
                            var n = T.type(t);
                            "function" === n ? r.unique && h.has(t) || l.push(t) : t && t.length && "string" !== n && i(t)
                        })
                    }(arguments),
                        o ? a = l.length : t && (s = e,
                            d(t))
                }
                return this
            },
            remove: function () {
                return l && T.each(arguments, function (e, t) {
                    for (var n; -1 < (n = T.inArray(t, l, n));)
                        l.splice(n, 1),
                        o && (n <= a && a--,
                        n <= u && u--)
                }),
                    this
            },
            has: function (e) {
                return e ? -1 < T.inArray(e, l) : !(!l || !l.length)
            },
            empty: function () {
                return l = [],
                    a = 0,
                    this
            },
            disable: function () {
                return l = c = t = void 0,
                    this
            },
            disabled: function () {
                return !l
            },
            lock: function () {
                return c = void 0,
                t || h.disable(),
                    this
            },
            locked: function () {
                return !c
            },
            fireWith: function (e, t) {
                return !l || i && !c || (t = [e, (t = t || []).slice ? t.slice() : t],
                    o ? c.push(t) : d(t)),
                    this
            },
            fire: function () {
                return h.fireWith(this, arguments),
                    this
            },
            fired: function () {
                return !!i
            }
        };
        return h
    }
        ,
        T.extend({
            Deferred: function (e) {
                var o = [["resolve", "done", T.Callbacks("once memory"), "resolved"], ["reject", "fail", T.Callbacks("once memory"), "rejected"], ["notify", "progress", T.Callbacks("memory")]]
                    , r = "pending"
                    , s = {
                    state: function () {
                        return r
                    },
                    always: function () {
                        return a.done(arguments).fail(arguments),
                            this
                    },
                    then: function () {
                        var r = arguments;
                        return T.Deferred(function (i) {
                            T.each(o, function (e, t) {
                                var n = T.isFunction(r[e]) && r[e];
                                a[t[1]](function () {
                                    var e = n && n.apply(this, arguments);
                                    e && T.isFunction(e.promise) ? e.promise().done(i.resolve).fail(i.reject).progress(i.notify) : i[t[0] + "With"](this === s ? i.promise() : this, n ? [e] : arguments)
                                })
                            }),
                                r = null
                        }).promise()
                    },
                    promise: function (e) {
                        return null != e ? T.extend(e, s) : s
                    }
                }
                    , a = {};
                return s.pipe = s.then,
                    T.each(o, function (e, t) {
                        var n = t[2]
                            , i = t[3];
                        s[t[1]] = n.add,
                        i && n.add(function () {
                            r = i
                        }, o[1 ^ e][2].disable, o[2][2].lock),
                            a[t[0]] = function () {
                                return a[t[0] + "With"](this === a ? s : this, arguments),
                                    this
                            }
                            ,
                            a[t[0] + "With"] = n.fireWith
                    }),
                    s.promise(a),
                e && e.call(a, a),
                    a
            },
            when: function (e) {
                var r, t, n, i = 0, o = c.call(arguments), s = o.length,
                    a = 1 !== s || e && T.isFunction(e.promise) ? s : 0, u = 1 === a ? e : T.Deferred(),
                    l = function (t, n, i) {
                        return function (e) {
                            n[t] = this,
                                i[t] = 1 < arguments.length ? c.call(arguments) : e,
                                i === r ? u.notifyWith(n, i) : --a || u.resolveWith(n, i)
                        }
                    };
                if (1 < s)
                    for (r = new Array(s),
                             t = new Array(s),
                             n = new Array(s); i < s; i++)
                        o[i] && T.isFunction(o[i].promise) ? o[i].promise().done(l(i, n, o)).fail(u.reject).progress(l(i, t, r)) : --a;
                return a || u.resolveWith(n, o),
                    u.promise()
            }
        }),
        T.fn.ready = function (e) {
            return T.ready.promise().done(e),
                this
        }
        ,
        T.extend({
            isReady: !1,
            readyWait: 1,
            holdReady: function (e) {
                e ? T.readyWait++ : T.ready(!0)
            },
            ready: function (e) {
                (!0 === e ? --T.readyWait : T.isReady) || ((T.isReady = !0) !== e && 0 < --T.readyWait || (N.resolveWith(y, [T]),
                T.fn.triggerHandler && (T(y).triggerHandler("ready"),
                    T(y).off("ready"))))
            }
        }),
        T.ready.promise = function (e) {
            return N || (N = T.Deferred(),
                "complete" === y.readyState ? setTimeout(T.ready) : (y.addEventListener("DOMContentLoaded", j, !1),
                    p.addEventListener("load", j, !1))),
                N.promise(e)
        }
        ,
        T.ready.promise();
    var q = T.access = function (e, t, n, i, r, o, s) {
            var a = 0
                , u = e.length
                , l = null == n;
            if ("object" === T.type(n))
                for (a in r = !0,
                    n)
                    T.access(e, t, a, n[a], !0, o, s);
            else if (void 0 !== i && (r = !0,
            T.isFunction(i) || (s = !0),
            l && (t = s ? (t.call(e, i),
                null) : (l = t,
                    function (e, t, n) {
                        return l.call(T(e), n)
                    }
            )),
                t))
                for (; a < u; a++)
                    t(e[a], n, s ? i : i.call(e[a], a, t(e[a], n)));
            return r ? e : l ? t.call(e) : u ? t(e[0], n) : o
        }
    ;

    function O() {
        Object.defineProperty(this.cache = {}, 0, {
            get: function () {
                return {}
            }
        }),
            this.expando = T.expando + O.uid++
    }

    T.acceptData = function (e) {
        return 1 === e.nodeType || 9 === e.nodeType || !+e.nodeType
    }
        ,
        O.uid = 1,
        O.accepts = T.acceptData,
        O.prototype = {
            key: function (t) {
                if (!O.accepts(t))
                    return 0;
                var n = {}
                    , i = t[this.expando];
                if (!i) {
                    i = O.uid++;
                    try {
                        n[this.expando] = {
                            value: i
                        },
                            Object.defineProperties(t, n)
                    } catch (e) {
                        n[this.expando] = i,
                            T.extend(t, n)
                    }
                }
                return this.cache[i] || (this.cache[i] = {}),
                    i
            },
            set: function (e, t, n) {
                var i, r = this.key(e), o = this.cache[r];
                if ("string" == typeof t)
                    o[t] = n;
                else if (T.isEmptyObject(o))
                    T.extend(this.cache[r], t);
                else
                    for (i in t)
                        o[i] = t[i];
                return o
            },
            get: function (e, t) {
                var n = this.cache[this.key(e)];
                return void 0 === t ? n : n[t]
            },
            access: function (e, t, n) {
                var i;
                return void 0 === t || t && "string" == typeof t && void 0 === n ? void 0 !== (i = this.get(e, t)) ? i : this.get(e, T.camelCase(t)) : (this.set(e, t, n),
                    void 0 !== n ? n : t)
            },
            remove: function (e, t) {
                var n, i, r, o = this.key(e), s = this.cache[o];
                if (void 0 === t)
                    this.cache[o] = {};
                else {
                    n = (i = T.isArray(t) ? t.concat(t.map(T.camelCase)) : (r = T.camelCase(t),
                        t in s ? [t, r] : (i = r) in s ? [i] : i.match(A) || [])).length;
                    for (; n--;)
                        delete s[i[n]]
                }
            },
            hasData: function (e) {
                return !T.isEmptyObject(this.cache[e[this.expando]] || {})
            },
            discard: function (e) {
                e[this.expando] && delete this.cache[e[this.expando]]
            }
        };
    var z = new O
        , P = new O
        , D = /^(?:\{[\w\W]*\}|\[[\w\W]*\])$/
        , M = /([A-Z])/g;

    function F(e, t, n) {
        var i;
        if (void 0 === n && 1 === e.nodeType)
            if (i = "data-" + t.replace(M, "-$1").toLowerCase(),
            "string" == typeof (n = e.getAttribute(i))) {
                try {
                    n = "true" === n || "false" !== n && ("null" === n ? null : +n + "" === n ? +n : D.test(n) ? T.parseJSON(n) : n)
                } catch (e) {
                }
                P.set(e, t, n)
            } else
                n = void 0;
        return n
    }

    T.extend({
        hasData: function (e) {
            return P.hasData(e) || z.hasData(e)
        },
        data: function (e, t, n) {
            return P.access(e, t, n)
        },
        removeData: function (e, t) {
            P.remove(e, t)
        },
        _data: function (e, t, n) {
            return z.access(e, t, n)
        },
        _removeData: function (e, t) {
            z.remove(e, t)
        }
    }),
        T.fn.extend({
            data: function (i, e) {
                var t, n, r, o = this[0], s = o && o.attributes;
                if (void 0 !== i)
                    return "object" == typeof i ? this.each(function () {
                        P.set(this, i)
                    }) : q(this, function (t) {
                        var e, n = T.camelCase(i);
                        if (o && void 0 === t) {
                            if (void 0 !== (e = P.get(o, i)))
                                return e;
                            if (void 0 !== (e = P.get(o, n)))
                                return e;
                            if (void 0 !== (e = F(o, n, void 0)))
                                return e
                        } else
                            this.each(function () {
                                var e = P.get(this, n);
                                P.set(this, n, t),
                                -1 !== i.indexOf("-") && void 0 !== e && P.set(this, i, t)
                            })
                    }, null, e, 1 < arguments.length, null, !0);
                if (this.length && (r = P.get(o),
                1 === o.nodeType && !z.get(o, "hasDataAttrs"))) {
                    for (t = s.length; t--;)
                        s[t] && (0 === (n = s[t].name).indexOf("data-") && (n = T.camelCase(n.slice(5)),
                            F(o, n, r[n])));
                    z.set(o, "hasDataAttrs", !0)
                }
                return r
            },
            removeData: function (e) {
                return this.each(function () {
                    P.remove(this, e)
                })
            }
        }),
        T.extend({
            queue: function (e, t, n) {
                var i;
                return e ? (t = (t || "fx") + "queue",
                    i = z.get(e, t),
                n && (!i || T.isArray(n) ? i = z.access(e, t, T.makeArray(n)) : i.push(n)),
                i || []) : void 0
            },
            dequeue: function (e, t) {
                t = t || "fx";
                var n = T.queue(e, t)
                    , i = n.length
                    , r = n.shift()
                    , o = T._queueHooks(e, t);
                "inprogress" === r && (r = n.shift(),
                    i--),
                r && ("fx" === t && n.unshift("inprogress"),
                    delete o.stop,
                    r.call(e, function () {
                        T.dequeue(e, t)
                    }, o)),
                !i && o && o.empty.fire()
            },
            _queueHooks: function (e, t) {
                var n = t + "queueHooks";
                return z.get(e, n) || z.access(e, n, {
                    empty: T.Callbacks("once memory").add(function () {
                        z.remove(e, [t + "queue", n])
                    })
                })
            }
        }),
        T.fn.extend({
            queue: function (t, n) {
                var e = 2;
                return "string" != typeof t && (n = t,
                    t = "fx",
                    e--),
                    arguments.length < e ? T.queue(this[0], t) : void 0 === n ? this : this.each(function () {
                        var e = T.queue(this, t, n);
                        T._queueHooks(this, t),
                        "fx" === t && "inprogress" !== e[0] && T.dequeue(this, t)
                    })
            },
            dequeue: function (e) {
                return this.each(function () {
                    T.dequeue(this, e)
                })
            },
            clearQueue: function (e) {
                return this.queue(e || "fx", [])
            },
            promise: function (e, t) {
                var n, i = 1, r = T.Deferred(), o = this, s = this.length, a = function () {
                    --i || r.resolveWith(o, [o])
                };
                for ("string" != typeof e && (t = e,
                    e = void 0),
                         e = e || "fx"; s--;)
                    (n = z.get(o[s], e + "queueHooks")) && n.empty && (i++,
                        n.empty.add(a));
                return a(),
                    r.promise(t)
            }
        });
    var H, R, $ = /[+-]?(?:\d*\.|)\d+(?:[eE][+-]?\d+|)/.source, W = ["Top", "Right", "Bottom", "Left"],
        B = function (e, t) {
            return e = t || e,
            "none" === T.css(e, "display") || !T.contains(e.ownerDocument, e)
        }, U = /^(?:checkbox|radio)$/i;
    H = y.createDocumentFragment().appendChild(y.createElement("div")),
        (R = y.createElement("input")).setAttribute("type", "radio"),
        R.setAttribute("checked", "checked"),
        R.setAttribute("name", "t"),
        H.appendChild(R),
        v.checkClone = H.cloneNode(!0).cloneNode(!0).lastChild.checked,
        H.innerHTML = "<textarea>x</textarea>",
        v.noCloneChecked = !!H.cloneNode(!0).lastChild.defaultValue;
    var Y = "undefined";
    v.focusinBubbles = "onfocusin" in p;
    var X = /^key/
        , V = /^(?:mouse|pointer|contextmenu)|click/
        , Q = /^(?:focusinfocus|focusoutblur)$/
        , G = /^([^.]*)(?:\.(.+)|)$/;

    function Z() {
        return !0
    }

    function K() {
        return !1
    }

    function J() {
        try {
            return y.activeElement
        } catch (e) {
        }
    }

    T.event = {
        global: {},
        add: function (t, e, n, i, r) {
            var o, s, a, u, l, c, d, h, f, p, m, g = z.get(t);
            if (g)
                for (n.handler && (n = (o = n).handler,
                    r = o.selector),
                     n.guid || (n.guid = T.guid++),
                     (u = g.events) || (u = g.events = {}),
                     (s = g.handle) || (s = g.handle = function (e) {
                             return typeof T !== Y && T.event.triggered !== e.type ? T.event.dispatch.apply(t, arguments) : void 0
                         }
                     ),
                         l = (e = (e || "").match(A) || [""]).length; l--;)
                    f = m = (a = G.exec(e[l]) || [])[1],
                        p = (a[2] || "").split(".").sort(),
                    f && (d = T.event.special[f] || {},
                        f = (r ? d.delegateType : d.bindType) || f,
                        d = T.event.special[f] || {},
                        c = T.extend({
                            type: f,
                            origType: m,
                            data: i,
                            handler: n,
                            guid: n.guid,
                            selector: r,
                            needsContext: r && T.expr.match.needsContext.test(r),
                            namespace: p.join(".")
                        }, o),
                    (h = u[f]) || ((h = u[f] = []).delegateCount = 0,
                    d.setup && !1 !== d.setup.call(t, i, p, s) || t.addEventListener && t.addEventListener(f, s, !1)),
                    d.add && (d.add.call(t, c),
                    c.handler.guid || (c.handler.guid = n.guid)),
                        r ? h.splice(h.delegateCount++, 0, c) : h.push(c),
                        T.event.global[f] = !0)
        },
        remove: function (e, t, n, i, r) {
            var o, s, a, u, l, c, d, h, f, p, m, g = z.hasData(e) && z.get(e);
            if (g && (u = g.events)) {
                for (l = (t = (t || "").match(A) || [""]).length; l--;)
                    if (f = m = (a = G.exec(t[l]) || [])[1],
                        p = (a[2] || "").split(".").sort(),
                        f) {
                        for (d = T.event.special[f] || {},
                                 h = u[f = (i ? d.delegateType : d.bindType) || f] || [],
                                 a = a[2] && new RegExp("(^|\\.)" + p.join("\\.(?:.*\\.|)") + "(\\.|$)"),
                                 s = o = h.length; o--;)
                            c = h[o],
                            !r && m !== c.origType || n && n.guid !== c.guid || a && !a.test(c.namespace) || i && i !== c.selector && ("**" !== i || !c.selector) || (h.splice(o, 1),
                            c.selector && h.delegateCount--,
                            d.remove && d.remove.call(e, c));
                        s && !h.length && (d.teardown && !1 !== d.teardown.call(e, p, g.handle) || T.removeEvent(e, f, g.handle),
                            delete u[f])
                    } else
                        for (f in u)
                            T.event.remove(e, f + t[l], n, i, !0);
                T.isEmptyObject(u) && (delete g.handle,
                    z.remove(e, "events"))
            }
        },
        trigger: function (e, t, n, i) {
            var r, o, s, a, u, l, c, d = [n || y], h = g.call(e, "type") ? e.type : e,
                f = g.call(e, "namespace") ? e.namespace.split(".") : [];
            if (o = s = n = n || y,
            3 !== n.nodeType && 8 !== n.nodeType && !Q.test(h + T.event.triggered) && (0 <= h.indexOf(".") && (h = (f = h.split(".")).shift(),
                f.sort()),
                u = h.indexOf(":") < 0 && "on" + h,
                (e = e[T.expando] ? e : new T.Event(h, "object" == typeof e && e)).isTrigger = i ? 2 : 3,
                e.namespace = f.join("."),
                e.namespace_re = e.namespace ? new RegExp("(^|\\.)" + f.join("\\.(?:.*\\.|)") + "(\\.|$)") : null,
                e.result = void 0,
            e.target || (e.target = n),
                t = null == t ? [e] : T.makeArray(t, [e]),
                c = T.event.special[h] || {},
            i || !c.trigger || !1 !== c.trigger.apply(n, t))) {
                if (!i && !c.noBubble && !T.isWindow(n)) {
                    for (a = c.delegateType || h,
                         Q.test(a + h) || (o = o.parentNode); o; o = o.parentNode)
                        d.push(o),
                            s = o;
                    s === (n.ownerDocument || y) && d.push(s.defaultView || s.parentWindow || p)
                }
                for (r = 0; (o = d[r++]) && !e.isPropagationStopped();)
                    e.type = 1 < r ? a : c.bindType || h,
                    (l = (z.get(o, "events") || {})[e.type] && z.get(o, "handle")) && l.apply(o, t),
                    (l = u && o[u]) && l.apply && T.acceptData(o) && (e.result = l.apply(o, t),
                    !1 === e.result && e.preventDefault());
                return e.type = h,
                i || e.isDefaultPrevented() || c._default && !1 !== c._default.apply(d.pop(), t) || !T.acceptData(n) || u && T.isFunction(n[h]) && !T.isWindow(n) && ((s = n[u]) && (n[u] = null),
                    n[T.event.triggered = h](),
                    T.event.triggered = void 0,
                s && (n[u] = s)),
                    e.result
            }
        },
        dispatch: function (e) {
            e = T.event.fix(e);
            var t, n, i, r, o, s = [], a = c.call(arguments), u = (z.get(this, "events") || {})[e.type] || [],
                l = T.event.special[e.type] || {};
            if ((a[0] = e).delegateTarget = this,
            !l.preDispatch || !1 !== l.preDispatch.call(this, e)) {
                for (s = T.event.handlers.call(this, e, u),
                         t = 0; (r = s[t++]) && !e.isPropagationStopped();)
                    for (e.currentTarget = r.elem,
                             n = 0; (o = r.handlers[n++]) && !e.isImmediatePropagationStopped();)
                        (!e.namespace_re || e.namespace_re.test(o.namespace)) && (e.handleObj = o,
                            e.data = o.data,
                        void 0 !== (i = ((T.event.special[o.origType] || {}).handle || o.handler).apply(r.elem, a)) && !1 === (e.result = i) && (e.preventDefault(),
                            e.stopPropagation()));
                return l.postDispatch && l.postDispatch.call(this, e),
                    e.result
            }
        },
        handlers: function (e, t) {
            var n, i, r, o, s = [], a = t.delegateCount, u = e.target;
            if (a && u.nodeType && (!e.button || "click" !== e.type))
                for (; u !== this; u = u.parentNode || this)
                    if (!0 !== u.disabled || "click" !== e.type) {
                        for (i = [],
                                 n = 0; n < a; n++)
                            void 0 === i[r = (o = t[n]).selector + " "] && (i[r] = o.needsContext ? 0 <= T(r, this).index(u) : T.find(r, this, null, [u]).length),
                            i[r] && i.push(o);
                        i.length && s.push({
                            elem: u,
                            handlers: i
                        })
                    }
            return a < t.length && s.push({
                elem: this,
                handlers: t.slice(a)
            }),
                s
        },
        props: "altKey bubbles cancelable ctrlKey currentTarget eventPhase metaKey relatedTarget shiftKey target timeStamp view which".split(" "),
        fixHooks: {},
        keyHooks: {
            props: "char charCode key keyCode".split(" "),
            filter: function (e, t) {
                return null == e.which && (e.which = null != t.charCode ? t.charCode : t.keyCode),
                    e
            }
        },
        mouseHooks: {
            props: "button buttons clientX clientY offsetX offsetY pageX pageY screenX screenY toElement".split(" "),
            filter: function (e, t) {
                var n, i, r, o = t.button;
                return null == e.pageX && null != t.clientX && (i = (n = e.target.ownerDocument || y).documentElement,
                    r = n.body,
                    e.pageX = t.clientX + (i && i.scrollLeft || r && r.scrollLeft || 0) - (i && i.clientLeft || r && r.clientLeft || 0),
                    e.pageY = t.clientY + (i && i.scrollTop || r && r.scrollTop || 0) - (i && i.clientTop || r && r.clientTop || 0)),
                e.which || void 0 === o || (e.which = 1 & o ? 1 : 2 & o ? 3 : 4 & o ? 2 : 0),
                    e
            }
        },
        fix: function (e) {
            if (e[T.expando])
                return e;
            var t, n, i, r = e.type, o = e, s = this.fixHooks[r];
            for (s || (this.fixHooks[r] = s = V.test(r) ? this.mouseHooks : X.test(r) ? this.keyHooks : {}),
                     i = s.props ? this.props.concat(s.props) : this.props,
                     e = new T.Event(o),
                     t = i.length; t--;)
                e[n = i[t]] = o[n];
            return e.target || (e.target = y),
            3 === e.target.nodeType && (e.target = e.target.parentNode),
                s.filter ? s.filter(e, o) : e
        },
        special: {
            load: {
                noBubble: !0
            },
            focus: {
                trigger: function () {
                    return this !== J() && this.focus ? (this.focus(),
                        !1) : void 0
                },
                delegateType: "focusin"
            },
            blur: {
                trigger: function () {
                    return this === J() && this.blur ? (this.blur(),
                        !1) : void 0
                },
                delegateType: "focusout"
            },
            click: {
                trigger: function () {
                    return "checkbox" === this.type && this.click && T.nodeName(this, "input") ? (this.click(),
                        !1) : void 0
                },
                _default: function (e) {
                    return T.nodeName(e.target, "a")
                }
            },
            beforeunload: {
                postDispatch: function (e) {
                    void 0 !== e.result && e.originalEvent && (e.originalEvent.returnValue = e.result)
                }
            }
        },
        simulate: function (e, t, n, i) {
            var r = T.extend(new T.Event, n, {
                type: e,
                isSimulated: !0,
                originalEvent: {}
            });
            i ? T.event.trigger(r, null, t) : T.event.dispatch.call(t, r),
            r.isDefaultPrevented() && n.preventDefault()
        }
    },
        T.removeEvent = function (e, t, n) {
            e.removeEventListener && e.removeEventListener(t, n, !1)
        }
        ,
        T.Event = function (e, t) {
            return this instanceof T.Event ? (e && e.type ? (this.originalEvent = e,
                this.type = e.type,
                this.isDefaultPrevented = e.defaultPrevented || void 0 === e.defaultPrevented && !1 === e.returnValue ? Z : K) : this.type = e,
            t && T.extend(this, t),
                this.timeStamp = e && e.timeStamp || T.now(),
                void (this[T.expando] = !0)) : new T.Event(e, t)
        }
        ,
        T.Event.prototype = {
            isDefaultPrevented: K,
            isPropagationStopped: K,
            isImmediatePropagationStopped: K,
            preventDefault: function () {
                var e = this.originalEvent;
                this.isDefaultPrevented = Z,
                e && e.preventDefault && e.preventDefault()
            },
            stopPropagation: function () {
                var e = this.originalEvent;
                this.isPropagationStopped = Z,
                e && e.stopPropagation && e.stopPropagation()
            },
            stopImmediatePropagation: function () {
                var e = this.originalEvent;
                this.isImmediatePropagationStopped = Z,
                e && e.stopImmediatePropagation && e.stopImmediatePropagation(),
                    this.stopPropagation()
            }
        },
        T.each({
            mouseenter: "mouseover",
            mouseleave: "mouseout",
            pointerenter: "pointerover",
            pointerleave: "pointerout"
        }, function (e, r) {
            T.event.special[e] = {
                delegateType: r,
                bindType: r,
                handle: function (e) {
                    var t, n = e.relatedTarget, i = e.handleObj;
                    return (!n || n !== this && !T.contains(this, n)) && (e.type = i.origType,
                        t = i.handler.apply(this, arguments),
                        e.type = r),
                        t
                }
            }
        }),
    v.focusinBubbles || T.each({
        focus: "focusin",
        blur: "focusout"
    }, function (n, i) {
        var r = function (e) {
            T.event.simulate(i, e.target, T.event.fix(e), !0)
        };
        T.event.special[i] = {
            setup: function () {
                var e = this.ownerDocument || this
                    , t = z.access(e, i);
                t || e.addEventListener(n, r, !0),
                    z.access(e, i, (t || 0) + 1)
            },
            teardown: function () {
                var e = this.ownerDocument || this
                    , t = z.access(e, i) - 1;
                t ? z.access(e, i, t) : (e.removeEventListener(n, r, !0),
                    z.remove(e, i))
            }
        }
    }),
        T.fn.extend({
            on: function (e, t, n, i, r) {
                var o, s;
                if ("object" == typeof e) {
                    for (s in "string" != typeof t && (n = n || t,
                        t = void 0),
                        e)
                        this.on(s, t, n, e[s], r);
                    return this
                }
                if (null == n && null == i ? (i = t,
                    n = t = void 0) : null == i && ("string" == typeof t ? (i = n,
                    n = void 0) : (i = n,
                    n = t,
                    t = void 0)),
                !1 === i)
                    i = K;
                else if (!i)
                    return this;
                return 1 === r && (o = i,
                    (i = function (e) {
                            return T().off(e),
                                o.apply(this, arguments)
                        }
                    ).guid = o.guid || (o.guid = T.guid++)),
                    this.each(function () {
                        T.event.add(this, e, i, n, t)
                    })
            },
            one: function (e, t, n, i) {
                return this.on(e, t, n, i, 1)
            },
            off: function (e, t, n) {
                var i, r;
                if (e && e.preventDefault && e.handleObj)
                    return i = e.handleObj,
                        T(e.delegateTarget).off(i.namespace ? i.origType + "." + i.namespace : i.origType, i.selector, i.handler),
                        this;
                if ("object" != typeof e)
                    return (!1 === t || "function" == typeof t) && (n = t,
                        t = void 0),
                    !1 === n && (n = K),
                        this.each(function () {
                            T.event.remove(this, e, n, t)
                        });
                for (r in e)
                    this.off(r, t, e[r]);
                return this
            },
            trigger: function (e, t) {
                return this.each(function () {
                    T.event.trigger(e, t, this)
                })
            },
            triggerHandler: function (e, t) {
                var n = this[0];
                return n ? T.event.trigger(e, t, n, !0) : void 0
            }
        });
    var ee = /<(?!area|br|col|embed|hr|img|input|link|meta|param)(([\w:]+)[^>]*)\/>/gi
        , te = /<([\w:]+)/
        , ne = /<|&#?\w+;/
        , ie = /<(?:script|style|link)/i
        , re = /checked\s*(?:[^=]|=\s*.checked.)/i
        , oe = /^$|\/(?:java|ecma)script/i
        , se = /^true\/(.*)/
        , ae = /^\s*<!(?:\[CDATA\[|--)|(?:\]\]|--)>\s*$/g
        , ue = {
        option: [1, "<select multiple='multiple'>", "</select>"],
        thead: [1, "<table>", "</table>"],
        col: [2, "<table><colgroup>", "</colgroup></table>"],
        tr: [2, "<table><tbody>", "</tbody></table>"],
        td: [3, "<table><tbody><tr>", "</tr></tbody></table>"],
        _default: [0, "", ""]
    };

    function le(e, t) {
        return T.nodeName(e, "table") && T.nodeName(11 !== t.nodeType ? t : t.firstChild, "tr") ? e.getElementsByTagName("tbody")[0] || e.appendChild(e.ownerDocument.createElement("tbody")) : e
    }

    function ce(e) {
        return e.type = (null !== e.getAttribute("type")) + "/" + e.type,
            e
    }

    function de(e) {
        var t = se.exec(e.type);
        return t ? e.type = t[1] : e.removeAttribute("type"),
            e
    }

    function he(e, t) {
        for (var n = 0, i = e.length; n < i; n++)
            z.set(e[n], "globalEval", !t || z.get(t[n], "globalEval"))
    }

    function fe(e, t) {
        var n, i, r, o, s, a, u, l;
        if (1 === t.nodeType) {
            if (z.hasData(e) && (o = z.access(e),
                s = z.set(t, o),
                l = o.events))
                for (r in delete s.handle,
                    s.events = {},
                    l)
                    for (n = 0,
                             i = l[r].length; n < i; n++)
                        T.event.add(t, r, l[r][n]);
            P.hasData(e) && (a = P.access(e),
                u = T.extend({}, a),
                P.set(t, u))
        }
    }

    function pe(e, t) {
        var n = e.getElementsByTagName ? e.getElementsByTagName(t || "*") : e.querySelectorAll ? e.querySelectorAll(t || "*") : [];
        return void 0 === t || t && T.nodeName(e, t) ? T.merge([e], n) : n
    }

    ue.optgroup = ue.option,
        ue.tbody = ue.tfoot = ue.colgroup = ue.caption = ue.thead,
        ue.th = ue.td,
        T.extend({
            clone: function (e, t, n) {
                var i, r, o, s, a, u, l, c = e.cloneNode(!0), d = T.contains(e.ownerDocument, e);
                if (!(v.noCloneChecked || 1 !== e.nodeType && 11 !== e.nodeType || T.isXMLDoc(e)))
                    for (s = pe(c),
                             i = 0,
                             r = (o = pe(e)).length; i < r; i++)
                        a = o[i],
                            u = s[i],
                            void 0,
                            "input" === (l = u.nodeName.toLowerCase()) && U.test(a.type) ? u.checked = a.checked : ("input" === l || "textarea" === l) && (u.defaultValue = a.defaultValue);
                if (t)
                    if (n)
                        for (o = o || pe(e),
                                 s = s || pe(c),
                                 i = 0,
                                 r = o.length; i < r; i++)
                            fe(o[i], s[i]);
                    else
                        fe(e, c);
                return 0 < (s = pe(c, "script")).length && he(s, !d && pe(e, "script")),
                    c
            },
            buildFragment: function (e, t, n, i) {
                for (var r, o, s, a, u, l, c = t.createDocumentFragment(), d = [], h = 0, f = e.length; h < f; h++)
                    if ((r = e[h]) || 0 === r)
                        if ("object" === T.type(r))
                            T.merge(d, r.nodeType ? [r] : r);
                        else if (ne.test(r)) {
                            for (o = o || c.appendChild(t.createElement("div")),
                                     s = (te.exec(r) || ["", ""])[1].toLowerCase(),
                                     a = ue[s] || ue._default,
                                     o.innerHTML = a[1] + r.replace(ee, "<$1></$2>") + a[2],
                                     l = a[0]; l--;)
                                o = o.lastChild;
                            T.merge(d, o.childNodes),
                                (o = c.firstChild).textContent = ""
                        } else
                            d.push(t.createTextNode(r));
                for (c.textContent = "",
                         h = 0; r = d[h++];)
                    if ((!i || -1 === T.inArray(r, i)) && (u = T.contains(r.ownerDocument, r),
                        o = pe(c.appendChild(r), "script"),
                    u && he(o),
                        n))
                        for (l = 0; r = o[l++];)
                            oe.test(r.type || "") && n.push(r);
                return c
            },
            cleanData: function (e) {
                for (var t, n, i, r, o = T.event.special, s = 0; void 0 !== (n = e[s]); s++) {
                    if (T.acceptData(n) && ((r = n[z.expando]) && (t = z.cache[r]))) {
                        if (t.events)
                            for (i in t.events)
                                o[i] ? T.event.remove(n, i) : T.removeEvent(n, i, t.handle);
                        z.cache[r] && delete z.cache[r]
                    }
                    delete P.cache[n[P.expando]]
                }
            }
        }),
        T.fn.extend({
            text: function (e) {
                return q(this, function (e) {
                    return void 0 === e ? T.text(this) : this.empty().each(function () {
                        (1 === this.nodeType || 11 === this.nodeType || 9 === this.nodeType) && (this.textContent = e)
                    })
                }, null, e, arguments.length)
            },
            append: function () {
                return this.domManip(arguments, function (e) {
                    1 !== this.nodeType && 11 !== this.nodeType && 9 !== this.nodeType || le(this, e).appendChild(e)
                })
            },
            prepend: function () {
                return this.domManip(arguments, function (e) {
                    if (1 === this.nodeType || 11 === this.nodeType || 9 === this.nodeType) {
                        var t = le(this, e);
                        t.insertBefore(e, t.firstChild)
                    }
                })
            },
            before: function () {
                return this.domManip(arguments, function (e) {
                    this.parentNode && this.parentNode.insertBefore(e, this)
                })
            },
            after: function () {
                return this.domManip(arguments, function (e) {
                    this.parentNode && this.parentNode.insertBefore(e, this.nextSibling)
                })
            },
            remove: function (e, t) {
                for (var n, i = e ? T.filter(e, this) : this, r = 0; null != (n = i[r]); r++)
                    t || 1 !== n.nodeType || T.cleanData(pe(n)),
                    n.parentNode && (t && T.contains(n.ownerDocument, n) && he(pe(n, "script")),
                        n.parentNode.removeChild(n));
                return this
            },
            empty: function () {
                for (var e, t = 0; null != (e = this[t]); t++)
                    1 === e.nodeType && (T.cleanData(pe(e, !1)),
                        e.textContent = "");
                return this
            },
            clone: function (e, t) {
                return e = null != e && e,
                    t = null == t ? e : t,
                    this.map(function () {
                        return T.clone(this, e, t)
                    })
            },
            html: function (e) {
                return q(this, function (e) {
                    var t = this[0] || {}
                        , n = 0
                        , i = this.length;
                    if (void 0 === e && 1 === t.nodeType)
                        return t.innerHTML;
                    if ("string" == typeof e && !ie.test(e) && !ue[(te.exec(e) || ["", ""])[1].toLowerCase()]) {
                        e = e.replace(ee, "<$1></$2>");
                        try {
                            for (; n < i; n++)
                                1 === (t = this[n] || {}).nodeType && (T.cleanData(pe(t, !1)),
                                    t.innerHTML = e);
                            t = 0
                        } catch (e) {
                        }
                    }
                    t && this.empty().append(e)
                }, null, e, arguments.length)
            },
            replaceWith: function () {
                var t = arguments[0];
                return this.domManip(arguments, function (e) {
                    t = this.parentNode,
                        T.cleanData(pe(this)),
                    t && t.replaceChild(e, this)
                }),
                    t && (t.length || t.nodeType) ? this : this.remove()
            },
            detach: function (e) {
                return this.remove(e, !0)
            },
            domManip: function (n, i) {
                n = m.apply([], n);
                var e, t, r, o, s, a, u = 0, l = this.length, c = this, d = l - 1, h = n[0], f = T.isFunction(h);
                if (f || 1 < l && "string" == typeof h && !v.checkClone && re.test(h))
                    return this.each(function (e) {
                        var t = c.eq(e);
                        f && (n[0] = h.call(this, e, t.html())),
                            t.domManip(n, i)
                    });
                if (l && (t = (e = T.buildFragment(n, this[0].ownerDocument, !1, this)).firstChild,
                1 === e.childNodes.length && (e = t),
                    t)) {
                    for (o = (r = T.map(pe(e, "script"), ce)).length; u < l; u++)
                        s = e,
                        u !== d && (s = T.clone(s, !0, !0),
                        o && T.merge(r, pe(s, "script"))),
                            i.call(this[u], s, u);
                    if (o)
                        for (a = r[r.length - 1].ownerDocument,
                                 T.map(r, de),
                                 u = 0; u < o; u++)
                            s = r[u],
                            oe.test(s.type || "") && !z.access(s, "globalEval") && T.contains(a, s) && (s.src ? T._evalUrl && T._evalUrl(s.src) : T.globalEval(s.textContent.replace(ae, "")))
                }
                return this
            }
        }),
        T.each({
            appendTo: "append",
            prependTo: "prepend",
            insertBefore: "before",
            insertAfter: "after",
            replaceAll: "replaceWith"
        }, function (e, s) {
            T.fn[e] = function (e) {
                for (var t, n = [], i = T(e), r = i.length - 1, o = 0; o <= r; o++)
                    t = o === r ? this : this.clone(!0),
                        T(i[o])[s](t),
                        a.apply(n, t.get());
                return this.pushStack(n)
            }
        });
    var me, ge = {};

    function ve(e, t) {
        var n, i = T(t.createElement(e)).appendTo(t.body),
            r = p.getDefaultComputedStyle && (n = p.getDefaultComputedStyle(i[0])) ? n.display : T.css(i[0], "display");
        return i.detach(),
            r
    }

    function ye(e) {
        var t = y
            , n = ge[e];
        return n || ("none" !== (n = ve(e, t)) && n || ((t = (me = (me || T("<iframe frameborder='0' width='0' height='0'/>")).appendTo(t.documentElement))[0].contentDocument).write(),
            t.close(),
            n = ve(e, t),
            me.detach()),
            ge[e] = n),
            n
    }

    var be = /^margin/
        , xe = new RegExp("^(" + $ + ")(?!px)[a-z%]+$", "i")
        , we = function (e) {
        return e.ownerDocument.defaultView.opener ? e.ownerDocument.defaultView.getComputedStyle(e, null) : p.getComputedStyle(e, null)
    };

    function Ce(e, t, n) {
        var i, r, o, s, a = e.style;
        return (n = n || we(e)) && (s = n.getPropertyValue(t) || n[t]),
        n && ("" !== s || T.contains(e.ownerDocument, e) || (s = T.style(e, t)),
        xe.test(s) && be.test(t) && (i = a.width,
            r = a.minWidth,
            o = a.maxWidth,
            a.minWidth = a.maxWidth = a.width = s,
            s = n.width,
            a.width = i,
            a.minWidth = r,
            a.maxWidth = o)),
            void 0 !== s ? s + "" : s
    }

    function Te(e, t) {
        return {
            get: function () {
                return e() ? void delete this.get : (this.get = t).apply(this, arguments)
            }
        }
    }

    !function () {
        var t, n, i = y.documentElement, r = y.createElement("div"), o = y.createElement("div");
        if (o.style) {
            function e() {
                o.style.cssText = "-webkit-box-sizing:border-box;-moz-box-sizing:border-box;box-sizing:border-box;display:block;margin-top:1%;top:1%;border:1px;padding:1px;width:4px;position:absolute",
                    o.innerHTML = "",
                    i.appendChild(r);
                var e = p.getComputedStyle(o, null);
                t = "1%" !== e.top,
                    n = "4px" === e.width,
                    i.removeChild(r)
            }

            o.style.backgroundClip = "content-box",
                o.cloneNode(!0).style.backgroundClip = "",
                v.clearCloneStyle = "content-box" === o.style.backgroundClip,
                r.style.cssText = "border:0;width:0;height:0;top:0;left:-9999px;margin-top:1px;position:absolute",
                r.appendChild(o),
            p.getComputedStyle && T.extend(v, {
                pixelPosition: function () {
                    return e(),
                        t
                },
                boxSizingReliable: function () {
                    return null == n && e(),
                        n
                },
                reliableMarginRight: function () {
                    var e, t = o.appendChild(y.createElement("div"));
                    return t.style.cssText = o.style.cssText = "-webkit-box-sizing:content-box;-moz-box-sizing:content-box;box-sizing:content-box;display:block;margin:0;border:0;padding:0",
                        t.style.marginRight = t.style.width = "0",
                        o.style.width = "1px",
                        i.appendChild(r),
                        e = !parseFloat(p.getComputedStyle(t, null).marginRight),
                        i.removeChild(r),
                        o.removeChild(t),
                        e
                }
            })
        }
    }(),
        T.swap = function (e, t, n, i) {
            var r, o, s = {};
            for (o in t)
                s[o] = e.style[o],
                    e.style[o] = t[o];
            for (o in r = n.apply(e, i || []),
                t)
                e.style[o] = s[o];
            return r
        }
    ;
    var Ee = /^(none|table(?!-c[ea]).+)/
        , ke = new RegExp("^(" + $ + ")(.*)$", "i")
        , Se = new RegExp("^([+-])=(" + $ + ")", "i")
        , Ie = {
        position: "absolute",
        visibility: "hidden",
        display: "block"
    }
        , Le = {
        letterSpacing: "0",
        fontWeight: "400"
    }
        , Ne = ["Webkit", "O", "Moz", "ms"];

    function Ae(e, t) {
        if (t in e)
            return t;
        for (var n = t[0].toUpperCase() + t.slice(1), i = t, r = Ne.length; r--;)
            if ((t = Ne[r] + n) in e)
                return t;
        return i
    }

    function _e(e, t, n) {
        var i = ke.exec(t);
        return i ? Math.max(0, i[1] - (n || 0)) + (i[2] || "px") : t
    }

    function je(e, t, n, i, r) {
        for (var o = n === (i ? "border" : "content") ? 4 : "width" === t ? 1 : 0, s = 0; o < 4; o += 2)
            "margin" === n && (s += T.css(e, n + W[o], !0, r)),
                i ? ("content" === n && (s -= T.css(e, "padding" + W[o], !0, r)),
                "margin" !== n && (s -= T.css(e, "border" + W[o] + "Width", !0, r))) : (s += T.css(e, "padding" + W[o], !0, r),
                "padding" !== n && (s += T.css(e, "border" + W[o] + "Width", !0, r)));
        return s
    }

    function qe(e, t, n) {
        var i = !0
            , r = "width" === t ? e.offsetWidth : e.offsetHeight
            , o = we(e)
            , s = "border-box" === T.css(e, "boxSizing", !1, o);
        if (r <= 0 || null == r) {
            if (((r = Ce(e, t, o)) < 0 || null == r) && (r = e.style[t]),
                xe.test(r))
                return r;
            i = s && (v.boxSizingReliable() || r === e.style[t]),
                r = parseFloat(r) || 0
        }
        return r + je(e, t, n || (s ? "border" : "content"), i, o) + "px"
    }

    function Oe(e, t) {
        for (var n, i, r, o = [], s = 0, a = e.length; s < a; s++)
            (i = e[s]).style && (o[s] = z.get(i, "olddisplay"),
                n = i.style.display,
                t ? (o[s] || "none" !== n || (i.style.display = ""),
                "" === i.style.display && B(i) && (o[s] = z.access(i, "olddisplay", ye(i.nodeName)))) : (r = B(i),
                "none" === n && r || z.set(i, "olddisplay", r ? n : T.css(i, "display"))));
        for (s = 0; s < a; s++)
            (i = e[s]).style && (t && "none" !== i.style.display && "" !== i.style.display || (i.style.display = t ? o[s] || "" : "none"));
        return e
    }

    function ze(e, t, n, i, r) {
        return new ze.prototype.init(e, t, n, i, r)
    }

    T.extend({
        cssHooks: {
            opacity: {
                get: function (e, t) {
                    if (t) {
                        var n = Ce(e, "opacity");
                        return "" === n ? "1" : n
                    }
                }
            }
        },
        cssNumber: {
            columnCount: !0,
            fillOpacity: !0,
            flexGrow: !0,
            flexShrink: !0,
            fontWeight: !0,
            lineHeight: !0,
            opacity: !0,
            order: !0,
            orphans: !0,
            widows: !0,
            zIndex: !0,
            zoom: !0
        },
        cssProps: {
            float: "cssFloat"
        },
        style: function (e, t, n, i) {
            if (e && 3 !== e.nodeType && 8 !== e.nodeType && e.style) {
                var r, o, s, a = T.camelCase(t), u = e.style;
                return t = T.cssProps[a] || (T.cssProps[a] = Ae(u, a)),
                    s = T.cssHooks[t] || T.cssHooks[a],
                    void 0 === n ? s && "get" in s && void 0 !== (r = s.get(e, !1, i)) ? r : u[t] : ("string" === (o = typeof n) && (r = Se.exec(n)) && (n = (r[1] + 1) * r[2] + parseFloat(T.css(e, t)),
                        o = "number"),
                        void (null != n && n == n && ("number" !== o || T.cssNumber[a] || (n += "px"),
                        v.clearCloneStyle || "" !== n || 0 !== t.indexOf("background") || (u[t] = "inherit"),
                        s && "set" in s && void 0 === (n = s.set(e, n, i)) || (u[t] = n))))
            }
        },
        css: function (e, t, n, i) {
            var r, o, s, a = T.camelCase(t);
            return t = T.cssProps[a] || (T.cssProps[a] = Ae(e.style, a)),
            (s = T.cssHooks[t] || T.cssHooks[a]) && "get" in s && (r = s.get(e, !0, n)),
            void 0 === r && (r = Ce(e, t, i)),
            "normal" === r && t in Le && (r = Le[t]),
                "" === n || n ? (o = parseFloat(r),
                    !0 === n || T.isNumeric(o) ? o || 0 : r) : r
        }
    }),
        T.each(["height", "width"], function (e, r) {
            T.cssHooks[r] = {
                get: function (e, t, n) {
                    return t ? Ee.test(T.css(e, "display")) && 0 === e.offsetWidth ? T.swap(e, Ie, function () {
                        return qe(e, r, n)
                    }) : qe(e, r, n) : void 0
                },
                set: function (e, t, n) {
                    var i = n && we(e);
                    return _e(0, t, n ? je(e, r, n, "border-box" === T.css(e, "boxSizing", !1, i), i) : 0)
                }
            }
        }),
        T.cssHooks.marginRight = Te(v.reliableMarginRight, function (e, t) {
            return t ? T.swap(e, {
                display: "inline-block"
            }, Ce, [e, "marginRight"]) : void 0
        }),
        T.each({
            margin: "",
            padding: "",
            border: "Width"
        }, function (r, o) {
            T.cssHooks[r + o] = {
                expand: function (e) {
                    for (var t = 0, n = {}, i = "string" == typeof e ? e.split(" ") : [e]; t < 4; t++)
                        n[r + W[t] + o] = i[t] || i[t - 2] || i[0];
                    return n
                }
            },
            be.test(r) || (T.cssHooks[r + o].set = _e)
        }),
        T.fn.extend({
            css: function (e, t) {
                return q(this, function (e, t, n) {
                    var i, r, o = {}, s = 0;
                    if (T.isArray(t)) {
                        for (i = we(e),
                                 r = t.length; s < r; s++)
                            o[t[s]] = T.css(e, t[s], !1, i);
                        return o
                    }
                    return void 0 !== n ? T.style(e, t, n) : T.css(e, t)
                }, e, t, 1 < arguments.length)
            },
            show: function () {
                return Oe(this, !0)
            },
            hide: function () {
                return Oe(this)
            },
            toggle: function (e) {
                return "boolean" == typeof e ? e ? this.show() : this.hide() : this.each(function () {
                    B(this) ? T(this).show() : T(this).hide()
                })
            }
        }),
        ((T.Tween = ze).prototype = {
            constructor: ze,
            init: function (e, t, n, i, r, o) {
                this.elem = e,
                    this.prop = n,
                    this.easing = r || "swing",
                    this.options = t,
                    this.start = this.now = this.cur(),
                    this.end = i,
                    this.unit = o || (T.cssNumber[n] ? "" : "px")
            },
            cur: function () {
                var e = ze.propHooks[this.prop];
                return e && e.get ? e.get(this) : ze.propHooks._default.get(this)
            },
            run: function (e) {
                var t, n = ze.propHooks[this.prop];
                return this.options.duration ? this.pos = t = T.easing[this.easing](e, this.options.duration * e, 0, 1, this.options.duration) : this.pos = t = e,
                    this.now = (this.end - this.start) * t + this.start,
                this.options.step && this.options.step.call(this.elem, this.now, this),
                    n && n.set ? n.set(this) : ze.propHooks._default.set(this),
                    this
            }
        }).init.prototype = ze.prototype,
        (ze.propHooks = {
            _default: {
                get: function (e) {
                    var t;
                    return null == e.elem[e.prop] || e.elem.style && null != e.elem.style[e.prop] ? (t = T.css(e.elem, e.prop, "")) && "auto" !== t ? t : 0 : e.elem[e.prop]
                },
                set: function (e) {
                    T.fx.step[e.prop] ? T.fx.step[e.prop](e) : e.elem.style && (null != e.elem.style[T.cssProps[e.prop]] || T.cssHooks[e.prop]) ? T.style(e.elem, e.prop, e.now + e.unit) : e.elem[e.prop] = e.now
                }
            }
        }).scrollTop = ze.propHooks.scrollLeft = {
            set: function (e) {
                e.elem.nodeType && e.elem.parentNode && (e.elem[e.prop] = e.now)
            }
        },
        T.easing = {
            linear: function (e) {
                return e
            },
            swing: function (e) {
                return .5 - Math.cos(e * Math.PI) / 2
            }
        },
        T.fx = ze.prototype.init,
        T.fx.step = {};
    var Pe, De, Me, Fe, He, Re = /^(?:toggle|show|hide)$/, $e = new RegExp("^(?:([+-])=|)(" + $ + ")([a-z%]*)$", "i"),
        We = /queueHooks$/, Be = [function (t, e, n) {
            var i, r, o, s, a, u, l, c = this, d = {}, h = t.style, f = t.nodeType && B(t), p = z.get(t, "fxshow");
            for (i in n.queue || (null == (a = T._queueHooks(t, "fx")).unqueued && (a.unqueued = 0,
                    u = a.empty.fire,
                    a.empty.fire = function () {
                        a.unqueued || u()
                    }
            ),
                a.unqueued++,
                c.always(function () {
                    c.always(function () {
                        a.unqueued--,
                        T.queue(t, "fx").length || a.empty.fire()
                    })
                })),
            1 === t.nodeType && ("height" in e || "width" in e) && (n.overflow = [h.overflow, h.overflowX, h.overflowY],
                l = T.css(t, "display"),
            "inline" === ("none" === l ? z.get(t, "olddisplay") || ye(t.nodeName) : l) && "none" === T.css(t, "float") && (h.display = "inline-block")),
            n.overflow && (h.overflow = "hidden",
                c.always(function () {
                    h.overflow = n.overflow[0],
                        h.overflowX = n.overflow[1],
                        h.overflowY = n.overflow[2]
                })),
                e)
                if (r = e[i],
                    Re.exec(r)) {
                    if (delete e[i],
                        o = o || "toggle" === r,
                    r === (f ? "hide" : "show")) {
                        if ("show" !== r || !p || void 0 === p[i])
                            continue;
                        f = !0
                    }
                    d[i] = p && p[i] || T.style(t, i)
                } else
                    l = void 0;
            if (T.isEmptyObject(d))
                "inline" === ("none" === l ? ye(t.nodeName) : l) && (h.display = l);
            else
                for (i in p ? "hidden" in p && (f = p.hidden) : p = z.access(t, "fxshow", {}),
                o && (p.hidden = !f),
                    f ? T(t).show() : c.done(function () {
                        T(t).hide()
                    }),
                    c.done(function () {
                        var e;
                        for (e in z.remove(t, "fxshow"),
                            d)
                            T.style(t, e, d[e])
                    }),
                    d)
                    s = Ve(f ? p[i] : 0, i, c),
                    i in p || (p[i] = s.start,
                    f && (s.end = s.start,
                        s.start = "width" === i || "height" === i ? 1 : 0))
        }
        ], Ue = {
            "*": [function (e, t) {
                var n = this.createTween(e, t)
                    , i = n.cur()
                    , r = $e.exec(t)
                    , o = r && r[3] || (T.cssNumber[e] ? "" : "px")
                    , s = (T.cssNumber[e] || "px" !== o && +i) && $e.exec(T.css(n.elem, e))
                    , a = 1
                    , u = 20;
                if (s && s[3] !== o)
                    for (o = o || s[3],
                             r = r || [],
                             s = +i || 1; s /= a = a || ".5",
                             T.style(n.elem, e, s + o),
                         a !== (a = n.cur() / i) && 1 !== a && --u;)
                        ;
                return r && (s = n.start = +s || +i || 0,
                    n.unit = o,
                    n.end = r[1] ? s + (r[1] + 1) * r[2] : +r[2]),
                    n
            }
            ]
        };

    function Ye() {
        return setTimeout(function () {
            Pe = void 0
        }),
            Pe = T.now()
    }

    function Xe(e, t) {
        var n, i = 0, r = {
            height: e
        };
        for (t = t ? 1 : 0; i < 4; i += 2 - t)
            r["margin" + (n = W[i])] = r["padding" + n] = e;
        return t && (r.opacity = r.width = e),
            r
    }

    function Ve(e, t, n) {
        for (var i, r = (Ue[t] || []).concat(Ue["*"]), o = 0, s = r.length; o < s; o++)
            if (i = r[o].call(n, t, e))
                return i
    }

    function Qe(o, e, t) {
        var n, s, i = 0, r = Be.length, a = T.Deferred().always(function () {
            delete u.elem
        }), u = function () {
            if (s)
                return !1;
            for (var e = Pe || Ye(), t = Math.max(0, l.startTime + l.duration - e), n = 1 - (t / l.duration || 0), i = 0, r = l.tweens.length; i < r; i++)
                l.tweens[i].run(n);
            return a.notifyWith(o, [l, n, t]),
                n < 1 && r ? t : (a.resolveWith(o, [l]),
                    !1)
        }, l = a.promise({
            elem: o,
            props: T.extend({}, e),
            opts: T.extend(!0, {
                specialEasing: {}
            }, t),
            originalProperties: e,
            originalOptions: t,
            startTime: Pe || Ye(),
            duration: t.duration,
            tweens: [],
            createTween: function (e, t) {
                var n = T.Tween(o, l.opts, e, t, l.opts.specialEasing[e] || l.opts.easing);
                return l.tweens.push(n),
                    n
            },
            stop: function (e) {
                var t = 0
                    , n = e ? l.tweens.length : 0;
                if (s)
                    return this;
                for (s = !0; t < n; t++)
                    l.tweens[t].run(1);
                return e ? a.resolveWith(o, [l, e]) : a.rejectWith(o, [l, e]),
                    this
            }
        }), c = l.props;
        for (function (e, t) {
            var n, i, r, o, s;
            for (n in e)
                if (r = t[i = T.camelCase(n)],
                    o = e[n],
                T.isArray(o) && (r = o[1],
                    o = e[n] = o[0]),
                n !== i && (e[i] = o,
                    delete e[n]),
                (s = T.cssHooks[i]) && "expand" in s)
                    for (n in o = s.expand(o),
                        delete e[i],
                        o)
                        n in e || (e[n] = o[n],
                            t[n] = r);
                else
                    t[i] = r
        }(c, l.opts.specialEasing); i < r; i++)
            if (n = Be[i].call(l, o, c, l.opts))
                return n;
        return T.map(c, Ve, l),
        T.isFunction(l.opts.start) && l.opts.start.call(o, l),
            T.fx.timer(T.extend(u, {
                elem: o,
                anim: l,
                queue: l.opts.queue
            })),
            l.progress(l.opts.progress).done(l.opts.done, l.opts.complete).fail(l.opts.fail).always(l.opts.always)
    }

    T.Animation = T.extend(Qe, {
        tweener: function (e, t) {
            for (var n, i = 0, r = (e = T.isFunction(e) ? (t = e,
                ["*"]) : e.split(" ")).length; i < r; i++)
                n = e[i],
                    Ue[n] = Ue[n] || [],
                    Ue[n].unshift(t)
        },
        prefilter: function (e, t) {
            t ? Be.unshift(e) : Be.push(e)
        }
    }),
        T.speed = function (e, t, n) {
            var i = e && "object" == typeof e ? T.extend({}, e) : {
                complete: n || !n && t || T.isFunction(e) && e,
                duration: e,
                easing: n && t || t && !T.isFunction(t) && t
            };
            return i.duration = T.fx.off ? 0 : "number" == typeof i.duration ? i.duration : i.duration in T.fx.speeds ? T.fx.speeds[i.duration] : T.fx.speeds._default,
            (null == i.queue || !0 === i.queue) && (i.queue = "fx"),
                i.old = i.complete,
                i.complete = function () {
                    T.isFunction(i.old) && i.old.call(this),
                    i.queue && T.dequeue(this, i.queue)
                }
                ,
                i
        }
        ,
        T.fn.extend({
            fadeTo: function (e, t, n, i) {
                return this.filter(B).css("opacity", 0).show().end().animate({
                    opacity: t
                }, e, n, i)
            },
            animate: function (t, e, n, i) {
                var r = T.isEmptyObject(t)
                    , o = T.speed(e, n, i)
                    , s = function () {
                    var e = Qe(this, T.extend({}, t), o);
                    (r || z.get(this, "finish")) && e.stop(!0)
                };
                return s.finish = s,
                    r || !1 === o.queue ? this.each(s) : this.queue(o.queue, s)
            },
            stop: function (r, e, o) {
                var s = function (e) {
                    var t = e.stop;
                    delete e.stop,
                        t(o)
                };
                return "string" != typeof r && (o = e,
                    e = r,
                    r = void 0),
                e && !1 !== r && this.queue(r || "fx", []),
                    this.each(function () {
                        var e = !0
                            , t = null != r && r + "queueHooks"
                            , n = T.timers
                            , i = z.get(this);
                        if (t)
                            i[t] && i[t].stop && s(i[t]);
                        else
                            for (t in i)
                                i[t] && i[t].stop && We.test(t) && s(i[t]);
                        for (t = n.length; t--;)
                            n[t].elem !== this || null != r && n[t].queue !== r || (n[t].anim.stop(o),
                                e = !1,
                                n.splice(t, 1));
                        (e || !o) && T.dequeue(this, r)
                    })
            },
            finish: function (s) {
                return !1 !== s && (s = s || "fx"),
                    this.each(function () {
                        var e, t = z.get(this), n = t[s + "queue"], i = t[s + "queueHooks"], r = T.timers,
                            o = n ? n.length : 0;
                        for (t.finish = !0,
                                 T.queue(this, s, []),
                             i && i.stop && i.stop.call(this, !0),
                                 e = r.length; e--;)
                            r[e].elem === this && r[e].queue === s && (r[e].anim.stop(!0),
                                r.splice(e, 1));
                        for (e = 0; e < o; e++)
                            n[e] && n[e].finish && n[e].finish.call(this);
                        delete t.finish
                    })
            }
        }),
        T.each(["toggle", "show", "hide"], function (e, i) {
            var r = T.fn[i];
            T.fn[i] = function (e, t, n) {
                return null == e || "boolean" == typeof e ? r.apply(this, arguments) : this.animate(Xe(i, !0), e, t, n)
            }
        }),
        T.each({
            slideDown: Xe("show"),
            slideUp: Xe("hide"),
            slideToggle: Xe("toggle"),
            fadeIn: {
                opacity: "show"
            },
            fadeOut: {
                opacity: "hide"
            },
            fadeToggle: {
                opacity: "toggle"
            }
        }, function (e, i) {
            T.fn[e] = function (e, t, n) {
                return this.animate(i, e, t, n)
            }
        }),
        T.timers = [],
        T.fx.tick = function () {
            var e, t = 0, n = T.timers;
            for (Pe = T.now(); t < n.length; t++)
                (e = n[t])() || n[t] !== e || n.splice(t--, 1);
            n.length || T.fx.stop(),
                Pe = void 0
        }
        ,
        T.fx.timer = function (e) {
            T.timers.push(e),
                e() ? T.fx.start() : T.timers.pop()
        }
        ,
        T.fx.interval = 13,
        T.fx.start = function () {
            De || (De = setInterval(T.fx.tick, T.fx.interval))
        }
        ,
        T.fx.stop = function () {
            clearInterval(De),
                De = null
        }
        ,
        T.fx.speeds = {
            slow: 600,
            fast: 200,
            _default: 400
        },
        T.fn.delay = function (i, e) {
            return i = T.fx && T.fx.speeds[i] || i,
                e = e || "fx",
                this.queue(e, function (e, t) {
                    var n = setTimeout(e, i);
                    t.stop = function () {
                        clearTimeout(n)
                    }
                })
        }
        ,
        Me = y.createElement("input"),
        Fe = y.createElement("select"),
        He = Fe.appendChild(y.createElement("option")),
        Me.type = "checkbox",
        v.checkOn = "" !== Me.value,
        v.optSelected = He.selected,
        Fe.disabled = !0,
        v.optDisabled = !He.disabled,
        (Me = y.createElement("input")).value = "t",
        Me.type = "radio",
        v.radioValue = "t" === Me.value;
    var Ge, Ze = T.expr.attrHandle;
    T.fn.extend({
        attr: function (e, t) {
            return q(this, T.attr, e, t, 1 < arguments.length)
        },
        removeAttr: function (e) {
            return this.each(function () {
                T.removeAttr(this, e)
            })
        }
    }),
        T.extend({
            attr: function (e, t, n) {
                var i, r, o = e.nodeType;
                if (e && 3 !== o && 8 !== o && 2 !== o)
                    return typeof e.getAttribute === Y ? T.prop(e, t, n) : (1 === o && T.isXMLDoc(e) || (t = t.toLowerCase(),
                        i = T.attrHooks[t] || (T.expr.match.bool.test(t) ? Ge : void 0)),
                        void 0 === n ? i && "get" in i && null !== (r = i.get(e, t)) ? r : null == (r = T.find.attr(e, t)) ? void 0 : r : null !== n ? i && "set" in i && void 0 !== (r = i.set(e, n, t)) ? r : (e.setAttribute(t, n + ""),
                            n) : void T.removeAttr(e, t))
            },
            removeAttr: function (e, t) {
                var n, i, r = 0, o = t && t.match(A);
                if (o && 1 === e.nodeType)
                    for (; n = o[r++];)
                        i = T.propFix[n] || n,
                        T.expr.match.bool.test(n) && (e[i] = !1),
                            e.removeAttribute(n)
            },
            attrHooks: {
                type: {
                    set: function (e, t) {
                        if (!v.radioValue && "radio" === t && T.nodeName(e, "input")) {
                            var n = e.value;
                            return e.setAttribute("type", t),
                            n && (e.value = n),
                                t
                        }
                    }
                }
            }
        }),
        Ge = {
            set: function (e, t, n) {
                return !1 === t ? T.removeAttr(e, n) : e.setAttribute(n, n),
                    n
            }
        },
        T.each(T.expr.match.bool.source.match(/\w+/g), function (e, t) {
            var o = Ze[t] || T.find.attr;
            Ze[t] = function (e, t, n) {
                var i, r;
                return n || (r = Ze[t],
                    Ze[t] = i,
                    i = null != o(e, t, n) ? t.toLowerCase() : null,
                    Ze[t] = r),
                    i
            }
        });
    var Ke = /^(?:input|select|textarea|button)$/i;
    T.fn.extend({
        prop: function (e, t) {
            return q(this, T.prop, e, t, 1 < arguments.length)
        },
        removeProp: function (e) {
            return this.each(function () {
                delete this[T.propFix[e] || e]
            })
        }
    }),
        T.extend({
            propFix: {
                for: "htmlFor",
                class: "className"
            },
            prop: function (e, t, n) {
                var i, r, o = e.nodeType;
                if (e && 3 !== o && 8 !== o && 2 !== o)
                    return (1 !== o || !T.isXMLDoc(e)) && (t = T.propFix[t] || t,
                        r = T.propHooks[t]),
                        void 0 !== n ? r && "set" in r && void 0 !== (i = r.set(e, n, t)) ? i : e[t] = n : r && "get" in r && null !== (i = r.get(e, t)) ? i : e[t]
            },
            propHooks: {
                tabIndex: {
                    get: function (e) {
                        return e.hasAttribute("tabindex") || Ke.test(e.nodeName) || e.href ? e.tabIndex : -1
                    }
                }
            }
        }),
    v.optSelected || (T.propHooks.selected = {
        get: function (e) {
            var t = e.parentNode;
            return t && t.parentNode && t.parentNode.selectedIndex,
                null
        }
    }),
        T.each(["tabIndex", "readOnly", "maxLength", "cellSpacing", "cellPadding", "rowSpan", "colSpan", "useMap", "frameBorder", "contentEditable"], function () {
            T.propFix[this.toLowerCase()] = this
        });
    var Je = /[\t\r\n\f]/g;
    T.fn.extend({
        addClass: function (t) {
            var e, n, i, r, o, s, a = "string" == typeof t && t, u = 0, l = this.length;
            if (T.isFunction(t))
                return this.each(function (e) {
                    T(this).addClass(t.call(this, e, this.className))
                });
            if (a)
                for (e = (t || "").match(A) || []; u < l; u++)
                    if (i = 1 === (n = this[u]).nodeType && (n.className ? (" " + n.className + " ").replace(Je, " ") : " ")) {
                        for (o = 0; r = e[o++];)
                            i.indexOf(" " + r + " ") < 0 && (i += r + " ");
                        s = T.trim(i),
                        n.className !== s && (n.className = s)
                    }
            return this
        },
        removeClass: function (t) {
            var e, n, i, r, o, s, a = 0 === arguments.length || "string" == typeof t && t, u = 0, l = this.length;
            if (T.isFunction(t))
                return this.each(function (e) {
                    T(this).removeClass(t.call(this, e, this.className))
                });
            if (a)
                for (e = (t || "").match(A) || []; u < l; u++)
                    if (i = 1 === (n = this[u]).nodeType && (n.className ? (" " + n.className + " ").replace(Je, " ") : "")) {
                        for (o = 0; r = e[o++];)
                            for (; 0 <= i.indexOf(" " + r + " ");)
                                i = i.replace(" " + r + " ", " ");
                        s = t ? T.trim(i) : "",
                        n.className !== s && (n.className = s)
                    }
            return this
        },
        toggleClass: function (r, t) {
            var o = typeof r;
            return "boolean" == typeof t && "string" === o ? t ? this.addClass(r) : this.removeClass(r) : this.each(T.isFunction(r) ? function (e) {
                    T(this).toggleClass(r.call(this, e, this.className, t), t)
                }
                : function () {
                    if ("string" === o)
                        for (var e, t = 0, n = T(this), i = r.match(A) || []; e = i[t++];)
                            n.hasClass(e) ? n.removeClass(e) : n.addClass(e);
                    else
                        (o === Y || "boolean" === o) && (this.className && z.set(this, "__className__", this.className),
                            this.className = this.className || !1 === r ? "" : z.get(this, "__className__") || "")
                }
            )
        },
        hasClass: function (e) {
            for (var t = " " + e + " ", n = 0, i = this.length; n < i; n++)
                if (1 === this[n].nodeType && 0 <= (" " + this[n].className + " ").replace(Je, " ").indexOf(t))
                    return !0;
            return !1
        }
    });
    var et = /\r/g;
    T.fn.extend({
        val: function (n) {
            var i, e, r, t = this[0];
            return arguments.length ? (r = T.isFunction(n),
                this.each(function (e) {
                    var t;
                    1 === this.nodeType && (null == (t = r ? n.call(this, e, T(this).val()) : n) ? t = "" : "number" == typeof t ? t += "" : T.isArray(t) && (t = T.map(t, function (e) {
                        return null == e ? "" : e + ""
                    })),
                    (i = T.valHooks[this.type] || T.valHooks[this.nodeName.toLowerCase()]) && "set" in i && void 0 !== i.set(this, t, "value") || (this.value = t))
                })) : t ? (i = T.valHooks[t.type] || T.valHooks[t.nodeName.toLowerCase()]) && "get" in i && void 0 !== (e = i.get(t, "value")) ? e : "string" == typeof (e = t.value) ? e.replace(et, "") : null == e ? "" : e : void 0
        }
    }),
        T.extend({
            valHooks: {
                option: {
                    get: function (e) {
                        var t = T.find.attr(e, "value");
                        return null != t ? t : T.trim(T.text(e))
                    }
                },
                select: {
                    get: function (e) {
                        for (var t, n, i = e.options, r = e.selectedIndex, o = "select-one" === e.type || r < 0, s = o ? null : [], a = o ? r + 1 : i.length, u = r < 0 ? a : o ? r : 0; u < a; u++)
                            if (!(!(n = i[u]).selected && u !== r || (v.optDisabled ? n.disabled : null !== n.getAttribute("disabled")) || n.parentNode.disabled && T.nodeName(n.parentNode, "optgroup"))) {
                                if (t = T(n).val(),
                                    o)
                                    return t;
                                s.push(t)
                            }
                        return s
                    },
                    set: function (e, t) {
                        for (var n, i, r = e.options, o = T.makeArray(t), s = r.length; s--;)
                            ((i = r[s]).selected = 0 <= T.inArray(i.value, o)) && (n = !0);
                        return n || (e.selectedIndex = -1),
                            o
                    }
                }
            }
        }),
        T.each(["radio", "checkbox"], function () {
            T.valHooks[this] = {
                set: function (e, t) {
                    return T.isArray(t) ? e.checked = 0 <= T.inArray(T(e).val(), t) : void 0
                }
            },
            v.checkOn || (T.valHooks[this].get = function (e) {
                    return null === e.getAttribute("value") ? "on" : e.value
                }
            )
        }),
        T.each("blur focus focusin focusout load resize scroll unload click dblclick mousedown mouseup mousemove mouseover mouseout mouseenter mouseleave change select submit keydown keypress keyup error contextmenu".split(" "), function (e, n) {
            T.fn[n] = function (e, t) {
                return 0 < arguments.length ? this.on(n, null, e, t) : this.trigger(n)
            }
        }),
        T.fn.extend({
            hover: function (e, t) {
                return this.mouseenter(e).mouseleave(t || e)
            },
            bind: function (e, t, n) {
                return this.on(e, null, t, n)
            },
            unbind: function (e, t) {
                return this.off(e, null, t)
            },
            delegate: function (e, t, n, i) {
                return this.on(t, e, n, i)
            },
            undelegate: function (e, t, n) {
                return 1 === arguments.length ? this.off(e, "**") : this.off(t, e || "**", n)
            }
        });
    var tt = T.now()
        , nt = /\?/;
    T.parseJSON = function (e) {
        return JSON.parse(e + "")
    }
        ,
        T.parseXML = function (e) {
            var t;
            if (!e || "string" != typeof e)
                return null;
            try {
                t = (new DOMParser).parseFromString(e, "text/xml")
            } catch (e) {
                t = void 0
            }
            return (!t || t.getElementsByTagName("parsererror").length) && T.error("Invalid XML: " + e),
                t
        }
    ;
    var it = /#.*$/
        , rt = /([?&])_=[^&]*/
        , ot = /^(.*?):[ \t]*([^\r\n]*)$/gm
        , st = /^(?:GET|HEAD)$/
        , at = /^\/\//
        , ut = /^([\w.+-]+:)(?:\/\/(?:[^\/?#]*@|)([^\/?#:]*)(?::(\d+)|)|)/
        , lt = {}
        , ct = {}
        , dt = "*/".concat("*")
        , ht = p.location.href
        , ft = ut.exec(ht.toLowerCase()) || [];

    function pt(o) {
        return function (e, t) {
            "string" != typeof e && (t = e,
                e = "*");
            var n, i = 0, r = e.toLowerCase().match(A) || [];
            if (T.isFunction(t))
                for (; n = r[i++];)
                    "+" === n[0] ? (n = n.slice(1) || "*",
                        (o[n] = o[n] || []).unshift(t)) : (o[n] = o[n] || []).push(t)
        }
    }

    function mt(t, r, o, s) {
        var a = {}
            , u = t === ct;

        function l(e) {
            var i;
            return a[e] = !0,
                T.each(t[e] || [], function (e, t) {
                    var n = t(r, o, s);
                    return "string" != typeof n || u || a[n] ? u ? !(i = n) : void 0 : (r.dataTypes.unshift(n),
                        l(n),
                        !1)
                }),
                i
        }

        return l(r.dataTypes[0]) || !a["*"] && l("*")
    }

    function gt(e, t) {
        var n, i, r = T.ajaxSettings.flatOptions || {};
        for (n in t)
            void 0 !== t[n] && ((r[n] ? e : i || (i = {}))[n] = t[n]);
        return i && T.extend(!0, e, i),
            e
    }

    T.extend({
        active: 0,
        lastModified: {},
        etag: {},
        ajaxSettings: {
            url: ht,
            type: "GET",
            isLocal: /^(?:about|app|app-storage|.+-extension|file|res|widget):$/.test(ft[1]),
            global: !0,
            processData: !0,
            async: !0,
            contentType: "application/x-www-form-urlencoded; charset=UTF-8",
            accepts: {
                "*": dt,
                text: "text/plain",
                html: "text/html",
                xml: "application/xml, text/xml",
                json: "application/json, text/javascript"
            },
            contents: {
                xml: /xml/,
                html: /html/,
                json: /json/
            },
            responseFields: {
                xml: "responseXML",
                text: "responseText",
                json: "responseJSON"
            },
            converters: {
                "* text": String,
                "text html": !0,
                "text json": T.parseJSON,
                "text xml": T.parseXML
            },
            flatOptions: {
                url: !0,
                context: !0
            }
        },
        ajaxSetup: function (e, t) {
            return t ? gt(gt(e, T.ajaxSettings), t) : gt(T.ajaxSettings, e)
        },
        ajaxPrefilter: pt(lt),
        ajaxTransport: pt(ct),
        ajax: function (e, t) {
            "object" == typeof e && (t = e,
                e = void 0),
                t = t || {};
            var c, d, h, n, f, i, p, r, m = T.ajaxSetup({}, t), g = m.context || m,
                v = m.context && (g.nodeType || g.jquery) ? T(g) : T.event, y = T.Deferred(),
                b = T.Callbacks("once memory"), x = m.statusCode || {}, o = {}, s = {}, w = 0, a = "canceled", C = {
                    readyState: 0,
                    getResponseHeader: function (e) {
                        var t;
                        if (2 === w) {
                            if (!n)
                                for (n = {}; t = ot.exec(h);)
                                    n[t[1].toLowerCase()] = t[2];
                            t = n[e.toLowerCase()]
                        }
                        return null == t ? null : t
                    },
                    getAllResponseHeaders: function () {
                        return 2 === w ? h : null
                    },
                    setRequestHeader: function (e, t) {
                        var n = e.toLowerCase();
                        return w || (e = s[n] = s[n] || e,
                            o[e] = t),
                            this
                    },
                    overrideMimeType: function (e) {
                        return w || (m.mimeType = e),
                            this
                    },
                    statusCode: function (e) {
                        var t;
                        if (e)
                            if (w < 2)
                                for (t in e)
                                    x[t] = [x[t], e[t]];
                            else
                                C.always(e[C.status]);
                        return this
                    },
                    abort: function (e) {
                        var t = e || a;
                        return c && c.abort(t),
                            u(0, t),
                            this
                    }
                };
            if (y.promise(C).complete = b.add,
                C.success = C.done,
                C.error = C.fail,
                m.url = ((e || m.url || ht) + "").replace(it, "").replace(at, ft[1] + "//"),
                m.type = t.method || t.type || m.method || m.type,
                m.dataTypes = T.trim(m.dataType || "*").toLowerCase().match(A) || [""],
            null == m.crossDomain && (i = ut.exec(m.url.toLowerCase()),
                m.crossDomain = !(!i || i[1] === ft[1] && i[2] === ft[2] && (i[3] || ("http:" === i[1] ? "80" : "443")) === (ft[3] || ("http:" === ft[1] ? "80" : "443")))),
            m.data && m.processData && "string" != typeof m.data && (m.data = T.param(m.data, m.traditional)),
                mt(lt, m, t, C),
            2 === w)
                return C;
            for (r in (p = T.event && m.global) && 0 == T.active++ && T.event.trigger("ajaxStart"),
                m.type = m.type.toUpperCase(),
                m.hasContent = !st.test(m.type),
                d = m.url,
            m.hasContent || (m.data && (d = m.url += (nt.test(d) ? "&" : "?") + m.data,
                delete m.data),
            !1 === m.cache && (m.url = rt.test(d) ? d.replace(rt, "$1_=" + tt++) : d + (nt.test(d) ? "&" : "?") + "_=" + tt++)),
            m.ifModified && (T.lastModified[d] && C.setRequestHeader("If-Modified-Since", T.lastModified[d]),
            T.etag[d] && C.setRequestHeader("If-None-Match", T.etag[d])),
            (m.data && m.hasContent && !1 !== m.contentType || t.contentType) && C.setRequestHeader("Content-Type", m.contentType),
                C.setRequestHeader("Accept", m.dataTypes[0] && m.accepts[m.dataTypes[0]] ? m.accepts[m.dataTypes[0]] + ("*" !== m.dataTypes[0] ? ", " + dt + "; q=0.01" : "") : m.accepts["*"]),
                m.headers)
                C.setRequestHeader(r, m.headers[r]);
            if (m.beforeSend && (!1 === m.beforeSend.call(g, C, m) || 2 === w))
                return C.abort();
            for (r in a = "abort",
                {
                    success: 1,
                    error: 1,
                    complete: 1
                })
                C[r](m[r]);
            if (c = mt(ct, m, t, C)) {
                C.readyState = 1,
                p && v.trigger("ajaxSend", [C, m]),
                m.async && 0 < m.timeout && (f = setTimeout(function () {
                    C.abort("timeout")
                }, m.timeout));
                try {
                    w = 1,
                        c.send(o, u)
                } catch (e) {
                    if (!(w < 2))
                        throw e;
                    u(-1, e)
                }
            } else
                u(-1, "No Transport");

            function u(e, t, n, i) {
                var r, o, s, a, u, l = t;
                2 !== w && (w = 2,
                f && clearTimeout(f),
                    c = void 0,
                    h = i || "",
                    C.readyState = 0 < e ? 4 : 0,
                    r = 200 <= e && e < 300 || 304 === e,
                n && (a = function (e, t, n) {
                    for (var i, r, o, s, a = e.contents, u = e.dataTypes; "*" === u[0];)
                        u.shift(),
                        void 0 === i && (i = e.mimeType || t.getResponseHeader("Content-Type"));
                    if (i)
                        for (r in a)
                            if (a[r] && a[r].test(i)) {
                                u.unshift(r);
                                break
                            }
                    if (u[0] in n)
                        o = u[0];
                    else {
                        for (r in n) {
                            if (!u[0] || e.converters[r + " " + u[0]]) {
                                o = r;
                                break
                            }
                            s || (s = r)
                        }
                        o = o || s
                    }
                    return o ? (o !== u[0] && u.unshift(o),
                        n[o]) : void 0
                }(m, C, n)),
                    a = function (e, t, n, i) {
                        var r, o, s, a, u, l = {}, c = e.dataTypes.slice();
                        if (c[1])
                            for (s in e.converters)
                                l[s.toLowerCase()] = e.converters[s];
                        for (o = c.shift(); o;)
                            if (e.responseFields[o] && (n[e.responseFields[o]] = t),
                            !u && i && e.dataFilter && (t = e.dataFilter(t, e.dataType)),
                                u = o,
                                o = c.shift())
                                if ("*" === o)
                                    o = u;
                                else if ("*" !== u && u !== o) {
                                    if (!(s = l[u + " " + o] || l["* " + o]))
                                        for (r in l)
                                            if ((a = r.split(" "))[1] === o && (s = l[u + " " + a[0]] || l["* " + a[0]])) {
                                                !0 === s ? s = l[r] : !0 !== l[r] && (o = a[0],
                                                    c.unshift(a[1]));
                                                break
                                            }
                                    if (!0 !== s)
                                        if (s && e.throws)
                                            t = s(t);
                                        else
                                            try {
                                                t = s(t)
                                            } catch (e) {
                                                return {
                                                    state: "parsererror",
                                                    error: s ? e : "No conversion from " + u + " to " + o
                                                }
                                            }
                                }
                        return {
                            state: "success",
                            data: t
                        }
                    }(m, a, C, r),
                    r ? (m.ifModified && ((u = C.getResponseHeader("Last-Modified")) && (T.lastModified[d] = u),
                    (u = C.getResponseHeader("etag")) && (T.etag[d] = u)),
                        204 === e || "HEAD" === m.type ? l = "nocontent" : 304 === e ? l = "notmodified" : (l = a.state,
                            o = a.data,
                            r = !(s = a.error))) : (s = l,
                    (e || !l) && (l = "error",
                    e < 0 && (e = 0))),
                    C.status = e,
                    C.statusText = (t || l) + "",
                    r ? y.resolveWith(g, [o, l, C]) : y.rejectWith(g, [C, l, s]),
                    C.statusCode(x),
                    x = void 0,
                p && v.trigger(r ? "ajaxSuccess" : "ajaxError", [C, m, r ? o : s]),
                    b.fireWith(g, [C, l]),
                p && (v.trigger("ajaxComplete", [C, m]),
                --T.active || T.event.trigger("ajaxStop")))
            }

            return C
        },
        getJSON: function (e, t, n) {
            return T.get(e, t, n, "json")
        },
        getScript: function (e, t) {
            return T.get(e, void 0, t, "script")
        }
    }),
        T.each(["get", "post"], function (e, r) {
            T[r] = function (e, t, n, i) {
                return T.isFunction(t) && (i = i || n,
                    n = t,
                    t = void 0),
                    T.ajax({
                        url: e,
                        type: r,
                        dataType: i,
                        data: t,
                        success: n
                    })
            }
        }),
        T._evalUrl = function (e) {
            return T.ajax({
                url: e,
                type: "GET",
                dataType: "script",
                async: !1,
                global: !1,
                throws: !0
            })
        }
        ,
        T.fn.extend({
            wrapAll: function (t) {
                var e;
                return T.isFunction(t) ? this.each(function (e) {
                    T(this).wrapAll(t.call(this, e))
                }) : (this[0] && (e = T(t, this[0].ownerDocument).eq(0).clone(!0),
                this[0].parentNode && e.insertBefore(this[0]),
                    e.map(function () {
                        for (var e = this; e.firstElementChild;)
                            e = e.firstElementChild;
                        return e
                    }).append(this)),
                    this)
            },
            wrapInner: function (n) {
                return this.each(T.isFunction(n) ? function (e) {
                        T(this).wrapInner(n.call(this, e))
                    }
                    : function () {
                        var e = T(this)
                            , t = e.contents();
                        t.length ? t.wrapAll(n) : e.append(n)
                    }
                )
            },
            wrap: function (t) {
                var n = T.isFunction(t);
                return this.each(function (e) {
                    T(this).wrapAll(n ? t.call(this, e) : t)
                })
            },
            unwrap: function () {
                return this.parent().each(function () {
                    T.nodeName(this, "body") || T(this).replaceWith(this.childNodes)
                }).end()
            }
        }),
        T.expr.filters.hidden = function (e) {
            return e.offsetWidth <= 0 && e.offsetHeight <= 0
        }
        ,
        T.expr.filters.visible = function (e) {
            return !T.expr.filters.hidden(e)
        }
    ;
    var vt = /%20/g
        , yt = /\[\]$/
        , bt = /\r?\n/g
        , xt = /^(?:submit|button|image|reset|file)$/i
        , wt = /^(?:input|select|textarea|keygen)/i;

    function Ct(n, e, i, r) {
        var t;
        if (T.isArray(e))
            T.each(e, function (e, t) {
                i || yt.test(n) ? r(n, t) : Ct(n + "[" + ("object" == typeof t ? e : "") + "]", t, i, r)
            });
        else if (i || "object" !== T.type(e))
            r(n, e);
        else
            for (t in e)
                Ct(n + "[" + t + "]", e[t], i, r)
    }

    T.param = function (e, t) {
        var n, i = [], r = function (e, t) {
            t = T.isFunction(t) ? t() : null == t ? "" : t,
                i[i.length] = encodeURIComponent(e) + "=" + encodeURIComponent(t)
        };
        if (void 0 === t && (t = T.ajaxSettings && T.ajaxSettings.traditional),
        T.isArray(e) || e.jquery && !T.isPlainObject(e))
            T.each(e, function () {
                r(this.name, this.value)
            });
        else
            for (n in e)
                Ct(n, e[n], t, r);
        return i.join("&").replace(vt, "+")
    }
        ,
        T.fn.extend({
            serialize: function () {
                return T.param(this.serializeArray())
            },
            serializeArray: function () {
                return this.map(function () {
                    var e = T.prop(this, "elements");
                    return e ? T.makeArray(e) : this
                }).filter(function () {
                    var e = this.type;
                    return this.name && !T(this).is(":disabled") && wt.test(this.nodeName) && !xt.test(e) && (this.checked || !U.test(e))
                }).map(function (e, t) {
                    var n = T(this).val();
                    return null == n ? null : T.isArray(n) ? T.map(n, function (e) {
                        return {
                            name: t.name,
                            value: e.replace(bt, "\r\n")
                        }
                    }) : {
                        name: t.name,
                        value: n.replace(bt, "\r\n")
                    }
                }).get()
            }
        }),
        T.ajaxSettings.xhr = function () {
            try {
                return new XMLHttpRequest
            } catch (e) {
            }
        }
    ;
    var Tt = 0
        , Et = {}
        , kt = {
        0: 200,
        1223: 204
    }
        , St = T.ajaxSettings.xhr();
    p.attachEvent && p.attachEvent("onunload", function () {
        for (var e in Et)
            Et[e]()
    }),
        v.cors = !!St && "withCredentials" in St,
        v.ajax = St = !!St,
        T.ajaxTransport(function (o) {
            var s;
            return v.cors || St && !o.crossDomain ? {
                send: function (e, t) {
                    var n, i = o.xhr(), r = ++Tt;
                    if (i.open(o.type, o.url, o.async, o.username, o.password),
                        o.xhrFields)
                        for (n in o.xhrFields)
                            i[n] = o.xhrFields[n];
                    for (n in o.mimeType && i.overrideMimeType && i.overrideMimeType(o.mimeType),
                    o.crossDomain || e["X-Requested-With"] || (e["X-Requested-With"] = "XMLHttpRequest"),
                        e)
                        i.setRequestHeader(n, e[n]);
                    s = function (e) {
                        return function () {
                            s && (delete Et[r],
                                s = i.onload = i.onerror = null,
                                "abort" === e ? i.abort() : "error" === e ? t(i.status, i.statusText) : t(kt[i.status] || i.status, i.statusText, "string" == typeof i.responseText ? {
                                    text: i.responseText
                                } : void 0, i.getAllResponseHeaders()))
                        }
                    }
                        ,
                        i.onload = s(),
                        i.onerror = s("error"),
                        s = Et[r] = s("abort");
                    try {
                        i.send(o.hasContent && o.data || null)
                    } catch (e) {
                        if (s)
                            throw e
                    }
                },
                abort: function () {
                    s && s()
                }
            } : void 0
        }),
        T.ajaxSetup({
            accepts: {
                script: "text/javascript, application/javascript, application/ecmascript, application/x-ecmascript"
            },
            contents: {
                script: /(?:java|ecma)script/
            },
            converters: {
                "text script": function (e) {
                    return T.globalEval(e),
                        e
                }
            }
        }),
        T.ajaxPrefilter("script", function (e) {
            void 0 === e.cache && (e.cache = !1),
            e.crossDomain && (e.type = "GET")
        }),
        T.ajaxTransport("script", function (n) {
            var i, r;
            if (n.crossDomain)
                return {
                    send: function (e, t) {
                        i = T("<script>").prop({
                            async: !0,
                            charset: n.scriptCharset,
                            src: n.url
                        }).on("load error", r = function (e) {
                                i.remove(),
                                    r = null,
                                e && t("error" === e.type ? 404 : 200, e.type)
                            }
                        ),
                            y.head.appendChild(i[0])
                    },
                    abort: function () {
                        r && r()
                    }
                }
        });
    var It = []
        , Lt = /(=)\?(?=&|$)|\?\?/;
    T.ajaxSetup({
        jsonp: "callback",
        jsonpCallback: function () {
            var e = It.pop() || T.expando + "_" + tt++;
            return this[e] = !0,
                e
        }
    }),
        T.ajaxPrefilter("json jsonp", function (e, t, n) {
            var i, r, o,
                s = !1 !== e.jsonp && (Lt.test(e.url) ? "url" : "string" == typeof e.data && !(e.contentType || "").indexOf("application/x-www-form-urlencoded") && Lt.test(e.data) && "data");
            return s || "jsonp" === e.dataTypes[0] ? (i = e.jsonpCallback = T.isFunction(e.jsonpCallback) ? e.jsonpCallback() : e.jsonpCallback,
                s ? e[s] = e[s].replace(Lt, "$1" + i) : !1 !== e.jsonp && (e.url += (nt.test(e.url) ? "&" : "?") + e.jsonp + "=" + i),
                e.converters["script json"] = function () {
                    return o || T.error(i + " was not called"),
                        o[0]
                }
                ,
                e.dataTypes[0] = "json",
                r = p[i],
                p[i] = function () {
                    o = arguments
                }
                ,
                n.always(function () {
                    p[i] = r,
                    e[i] && (e.jsonpCallback = t.jsonpCallback,
                        It.push(i)),
                    o && T.isFunction(r) && r(o[0]),
                        o = r = void 0
                }),
                "script") : void 0
        }),
        T.parseHTML = function (e, t, n) {
            if (!e || "string" != typeof e)
                return null;
            "boolean" == typeof t && (n = t,
                t = !1),
                t = t || y;
            var i = x.exec(e)
                , r = !n && [];
            return i ? [t.createElement(i[1])] : (i = T.buildFragment([e], t, r),
            r && r.length && T(r).remove(),
                T.merge([], i.childNodes))
        }
    ;
    var Nt = T.fn.load;
    T.fn.load = function (e, t, n) {
        if ("string" != typeof e && Nt)
            return Nt.apply(this, arguments);
        var i, r, o, s = this, a = e.indexOf(" ");
        return 0 <= a && (i = T.trim(e.slice(a)),
            e = e.slice(0, a)),
            T.isFunction(t) ? (n = t,
                t = void 0) : t && "object" == typeof t && (r = "POST"),
        0 < s.length && T.ajax({
            url: e,
            type: r,
            dataType: "html",
            data: t
        }).done(function (e) {
            o = arguments,
                s.html(i ? T("<div>").append(T.parseHTML(e)).find(i) : e)
        }).complete(n && function (e, t) {
            s.each(n, o || [e.responseText, t, e])
        }
        ),
            this
    }
        ,
        T.each(["ajaxStart", "ajaxStop", "ajaxComplete", "ajaxError", "ajaxSuccess", "ajaxSend"], function (e, t) {
            T.fn[t] = function (e) {
                return this.on(t, e)
            }
        }),
        T.expr.filters.animated = function (t) {
            return T.grep(T.timers, function (e) {
                return t === e.elem
            }).length
        }
    ;
    var At = p.document.documentElement;

    function _t(e) {
        return T.isWindow(e) ? e : 9 === e.nodeType && e.defaultView
    }

    T.offset = {
        setOffset: function (e, t, n) {
            var i, r, o, s, a, u, l = T.css(e, "position"), c = T(e), d = {};
            "static" === l && (e.style.position = "relative"),
                a = c.offset(),
                o = T.css(e, "top"),
                u = T.css(e, "left"),
                r = ("absolute" === l || "fixed" === l) && -1 < (o + u).indexOf("auto") ? (s = (i = c.position()).top,
                    i.left) : (s = parseFloat(o) || 0,
                parseFloat(u) || 0),
            T.isFunction(t) && (t = t.call(e, n, a)),
            null != t.top && (d.top = t.top - a.top + s),
            null != t.left && (d.left = t.left - a.left + r),
                "using" in t ? t.using.call(e, d) : c.css(d)
        }
    },
        T.fn.extend({
            offset: function (t) {
                if (arguments.length)
                    return void 0 === t ? this : this.each(function (e) {
                        T.offset.setOffset(this, t, e)
                    });
                var e, n, i = this[0], r = {
                    top: 0,
                    left: 0
                }, o = i && i.ownerDocument;
                return o ? (e = o.documentElement,
                    T.contains(e, i) ? (typeof i.getBoundingClientRect !== Y && (r = i.getBoundingClientRect()),
                        n = _t(o),
                        {
                            top: r.top + n.pageYOffset - e.clientTop,
                            left: r.left + n.pageXOffset - e.clientLeft
                        }) : r) : void 0
            },
            position: function () {
                if (this[0]) {
                    var e, t, n = this[0], i = {
                        top: 0,
                        left: 0
                    };
                    return "fixed" === T.css(n, "position") ? t = n.getBoundingClientRect() : (e = this.offsetParent(),
                        t = this.offset(),
                    T.nodeName(e[0], "html") || (i = e.offset()),
                        i.top += T.css(e[0], "borderTopWidth", !0),
                        i.left += T.css(e[0], "borderLeftWidth", !0)),
                        {
                            top: t.top - i.top - T.css(n, "marginTop", !0),
                            left: t.left - i.left - T.css(n, "marginLeft", !0)
                        }
                }
            },
            offsetParent: function () {
                return this.map(function () {
                    for (var e = this.offsetParent || At; e && !T.nodeName(e, "html") && "static" === T.css(e, "position");)
                        e = e.offsetParent;
                    return e || At
                })
            }
        }),
        T.each({
            scrollLeft: "pageXOffset",
            scrollTop: "pageYOffset"
        }, function (t, r) {
            var o = "pageYOffset" === r;
            T.fn[t] = function (e) {
                return q(this, function (e, t, n) {
                    var i = _t(e);
                    return void 0 === n ? i ? i[r] : e[t] : void (i ? i.scrollTo(o ? p.pageXOffset : n, o ? n : p.pageYOffset) : e[t] = n)
                }, t, e, arguments.length, null)
            }
        }),
        T.each(["top", "left"], function (e, n) {
            T.cssHooks[n] = Te(v.pixelPosition, function (e, t) {
                return t ? (t = Ce(e, n),
                    xe.test(t) ? T(e).position()[n] + "px" : t) : void 0
            })
        }),
        T.each({
            Height: "height",
            Width: "width"
        }, function (o, s) {
            T.each({
                padding: "inner" + o,
                content: s,
                "": "outer" + o
            }, function (i, e) {
                T.fn[e] = function (e, t) {
                    var n = arguments.length && (i || "boolean" != typeof e)
                        , r = i || (!0 === e || !0 === t ? "margin" : "border");
                    return q(this, function (e, t, n) {
                        var i;
                        return T.isWindow(e) ? e.document.documentElement["client" + o] : 9 === e.nodeType ? (i = e.documentElement,
                            Math.max(e.body["scroll" + o], i["scroll" + o], e.body["offset" + o], i["offset" + o], i["client" + o])) : void 0 === n ? T.css(e, t, r) : T.style(e, t, n, r)
                    }, s, n ? e : void 0, n, null)
                }
            })
        }),
        T.fn.size = function () {
            return this.length
        }
        ,
        T.fn.andSelf = T.fn.addBack,
    "function" == typeof define && define.amd && define("jquery", [], function () {
        return T
    });
    var jt = p.jQuery
        , qt = p.$;
    return T.noConflict = function (e) {
        return p.$ === T && (p.$ = qt),
        e && p.jQuery === T && (p.jQuery = jt),
            T
    }
        ,
    typeof e === Y && (p.jQuery = p.$ = T),
        T
}),
    function (e) {
        "function" == typeof define && define.amd ? define(["jquery"], e) : "object" == typeof module && module.exports ? module.exports = e(require("jquery")) : e(jQuery)
    }(function (c) {
        c.extend(c.fn, {
            validate: function (e) {
                if (this.length) {
                    var i = c.data(this[0], "validator");
                    return i || (this.attr("novalidate", "novalidate"),
                        i = new c.validator(e, this[0]),
                        c.data(this[0], "validator", i),
                    i.settings.onsubmit && (this.on("click.validate", ":submit", function (e) {
                        i.settings.submitHandler && (i.submitButton = e.target),
                        c(this).hasClass("cancel") && (i.cancelSubmit = !0),
                        void 0 !== c(this).attr("formnovalidate") && (i.cancelSubmit = !0)
                    }),
                        this.on("submit.validate", function (n) {
                            function e() {
                                var e, t;
                                return !i.settings.submitHandler || (i.submitButton && (e = c("<input type='hidden'/>").attr("name", i.submitButton.name).val(c(i.submitButton).val()).appendTo(i.currentForm)),
                                    t = i.settings.submitHandler.call(i, i.currentForm, n),
                                i.submitButton && e.remove(),
                                void 0 !== t && t)
                            }

                            return i.settings.debug && n.preventDefault(),
                                i.cancelSubmit ? (i.cancelSubmit = !1,
                                    e()) : i.form() ? i.pendingRequest ? !(i.formSubmitted = !0) : e() : (i.focusInvalid(),
                                    !1)
                        })),
                        i)
                }
                e && e.debug && window.console && console.warn("Nothing selected, can't validate, returning nothing.")
            },
            valid: function () {
                var e, t, n;
                return c(this[0]).is("form") ? e = this.validate().form() : (n = [],
                    e = !0,
                    t = c(this[0].form).validate(),
                    this.each(function () {
                        (e = t.element(this) && e) || (n = n.concat(t.errorList))
                    }),
                    t.errorList = n),
                    e
            },
            rules: function (e, t) {
                if (this.length) {
                    var n, i, r, o, s, a, u = this[0];
                    if (e)
                        switch (i = (n = c.data(u.form, "validator").settings).rules,
                            r = c.validator.staticRules(u),
                            e) {
                            case "add":
                                c.extend(r, c.validator.normalizeRule(t)),
                                    delete r.messages,
                                    i[u.name] = r,
                                t.messages && (n.messages[u.name] = c.extend(n.messages[u.name], t.messages));
                                break;
                            case "remove":
                                return t ? (a = {},
                                    c.each(t.split(/\s/), function (e, t) {
                                        a[t] = r[t],
                                            delete r[t],
                                        "required" === t && c(u).removeAttr("aria-required")
                                    }),
                                    a) : (delete i[u.name],
                                    r)
                        }
                    return (o = c.validator.normalizeRules(c.extend({}, c.validator.classRules(u), c.validator.attributeRules(u), c.validator.dataRules(u), c.validator.staticRules(u)), u)).required && (s = o.required,
                        delete o.required,
                        o = c.extend({
                            required: s
                        }, o),
                        c(u).attr("aria-required", "true")),
                    o.remote && (s = o.remote,
                        delete o.remote,
                        o = c.extend(o, {
                            remote: s
                        })),
                        o
                }
            }
        }),
            c.extend(c.expr[":"], {
                blank: function (e) {
                    return !c.trim("" + c(e).val())
                },
                filled: function (e) {
                    var t = c(e).val();
                    return null !== t && !!c.trim("" + t)
                },
                unchecked: function (e) {
                    return !c(e).prop("checked")
                }
            }),
            c.validator = function (e, t) {
                this.settings = c.extend(!0, {}, c.validator.defaults, e),
                    this.currentForm = t,
                    this.init()
            }
            ,
            c.validator.format = function (n, e) {
                return 1 === arguments.length ? function () {
                        var e = c.makeArray(arguments);
                        return e.unshift(n),
                            c.validator.format.apply(this, e)
                    }
                    : (void 0 === e || (2 < arguments.length && e.constructor !== Array && (e = c.makeArray(arguments).slice(1)),
                    e.constructor !== Array && (e = [e]),
                        c.each(e, function (e, t) {
                            n = n.replace(new RegExp("\\{" + e + "\\}", "g"), function () {
                                return t
                            })
                        })),
                        n)
            }
            ,
            c.extend(c.validator, {
                defaults: {
                    messages: {},
                    groups: {},
                    rules: {},
                    errorClass: "error",
                    pendingClass: "pending",
                    validClass: "valid",
                    errorElement: "label",
                    focusCleanup: !1,
                    focusInvalid: !0,
                    errorContainer: c([]),
                    errorLabelContainer: c([]),
                    onsubmit: !0,
                    ignore: ":hidden",
                    ignoreTitle: !1,
                    onfocusin: function (e) {
                        this.lastActive = e,
                        this.settings.focusCleanup && (this.settings.unhighlight && this.settings.unhighlight.call(this, e, this.settings.errorClass, this.settings.validClass),
                            this.hideThese(this.errorsFor(e)))
                    },
                    onfocusout: function (e) {
                        this.checkable(e) || !(e.name in this.submitted) && this.optional(e) || this.element(e)
                    },
                    onkeyup: function (e, t) {
                        9 === t.which && "" === this.elementValue(e) || -1 !== c.inArray(t.keyCode, [16, 17, 18, 20, 35, 36, 37, 38, 39, 40, 45, 144, 225]) || (e.name in this.submitted || e.name in this.invalid) && this.element(e)
                    },
                    onclick: function (e) {
                        e.name in this.submitted ? this.element(e) : e.parentNode.name in this.submitted && this.element(e.parentNode)
                    },
                    highlight: function (e, t, n) {
                        "radio" === e.type ? this.findByName(e.name).addClass(t).removeClass(n) : c(e).addClass(t).removeClass(n)
                    },
                    unhighlight: function (e, t, n) {
                        "radio" === e.type ? this.findByName(e.name).removeClass(t).addClass(n) : c(e).removeClass(t).addClass(n)
                    }
                },
                setDefaults: function (e) {
                    c.extend(c.validator.defaults, e)
                },
                messages: {
                    required: "This field is required.",
                    remote: "Please fix this field.",
                    email: "Please enter a valid email address.",
                    url: "Please enter a valid URL.",
                    date: "Please enter a valid date.",
                    dateISO: "Please enter a valid date ( ISO ).",
                    number: "Please enter a valid number.",
                    digits: "Please enter only digits.",
                    equalTo: "Please enter the same value again.",
                    maxlength: c.validator.format("Please enter no more than {0} characters."),
                    minlength: c.validator.format("Please enter at least {0} characters."),
                    rangelength: c.validator.format("Please enter a value between {0} and {1} characters long."),
                    range: c.validator.format("Please enter a value between {0} and {1}."),
                    max: c.validator.format("Please enter a value less than or equal to {0}."),
                    min: c.validator.format("Please enter a value greater than or equal to {0}."),
                    step: c.validator.format("Please enter a multiple of {0}.")
                },
                autoCreateRanges: !1,
                prototype: {
                    init: function () {
                        this.labelContainer = c(this.settings.errorLabelContainer),
                            this.errorContext = this.labelContainer.length && this.labelContainer || c(this.currentForm),
                            this.containers = c(this.settings.errorContainer).add(this.settings.errorLabelContainer),
                            this.submitted = {},
                            this.valueCache = {},
                            this.pendingRequest = 0,
                            this.pending = {},
                            this.invalid = {},
                            this.reset();
                        var n, i = this.groups = {};

                        function e(e) {
                            var t = c.data(this.form, "validator")
                                , n = "on" + e.type.replace(/^validate/, "")
                                , i = t.settings;
                            i[n] && !c(this).is(i.ignore) && i[n].call(t, this, e)
                        }

                        c.each(this.settings.groups, function (n, e) {
                            "string" == typeof e && (e = e.split(/\s/)),
                                c.each(e, function (e, t) {
                                    i[t] = n
                                })
                        }),
                            n = this.settings.rules,
                            c.each(n, function (e, t) {
                                n[e] = c.validator.normalizeRule(t)
                            }),
                            c(this.currentForm).on("focusin.validate focusout.validate keyup.validate", ":text, [type='password'], [type='file'], select, textarea, [type='number'], [type='search'], [type='tel'], [type='url'], [type='email'], [type='datetime'], [type='date'], [type='month'], [type='week'], [type='time'], [type='datetime-local'], [type='range'], [type='color'], [type='radio'], [type='checkbox'], [contenteditable]", e).on("click.validate", "select, option, [type='radio'], [type='checkbox']", e),
                        this.settings.invalidHandler && c(this.currentForm).on("invalid-form.validate", this.settings.invalidHandler),
                            c(this.currentForm).find("[required], [data-rule-required], .required").attr("aria-required", "true")
                    },
                    form: function () {
                        return this.checkForm(),
                            c.extend(this.submitted, this.errorMap),
                            this.invalid = c.extend({}, this.errorMap),
                        this.valid() || c(this.currentForm).triggerHandler("invalid-form", [this]),
                            this.showErrors(),
                            this.valid()
                    },
                    checkForm: function () {
                        this.prepareForm();
                        for (var e = 0, t = this.currentElements = this.elements(); t[e]; e++)
                            this.check(t[e]);
                        return this.valid()
                    },
                    element: function (e) {
                        var t, n, i = this.clean(e), r = this.validationTargetFor(i), o = this, s = !0;
                        return void 0 === r ? delete this.invalid[i.name] : (this.prepareElement(r),
                            this.currentElements = c(r),
                        (n = this.groups[r.name]) && c.each(this.groups, function (e, t) {
                            t === n && e !== r.name && (i = o.validationTargetFor(o.clean(o.findByName(e)))) && i.name in o.invalid && (o.currentElements.push(i),
                                s = s && o.check(i))
                        }),
                            t = !1 !== this.check(r),
                            s = s && t,
                            this.invalid[r.name] = !t,
                        this.numberOfInvalids() || (this.toHide = this.toHide.add(this.containers)),
                            this.showErrors(),
                            c(e).attr("aria-invalid", !t)),
                            s
                    },
                    showErrors: function (t) {
                        if (t) {
                            var n = this;
                            c.extend(this.errorMap, t),
                                this.errorList = c.map(this.errorMap, function (e, t) {
                                    return {
                                        message: e,
                                        element: n.findByName(t)[0]
                                    }
                                }),
                                this.successList = c.grep(this.successList, function (e) {
                                    return !(e.name in t)
                                })
                        }
                        this.settings.showErrors ? this.settings.showErrors.call(this, this.errorMap, this.errorList) : this.defaultShowErrors()
                    },
                    resetForm: function () {
                        c.fn.resetForm && c(this.currentForm).resetForm(),
                            this.invalid = {},
                            this.submitted = {},
                            this.prepareForm(),
                            this.hideErrors();
                        var e = this.elements().removeData("previousValue").removeAttr("aria-invalid");
                        this.resetElements(e)
                    },
                    resetElements: function (e) {
                        var t;
                        if (this.settings.unhighlight)
                            for (t = 0; e[t]; t++)
                                this.settings.unhighlight.call(this, e[t], this.settings.errorClass, ""),
                                    this.findByName(e[t].name).removeClass(this.settings.validClass);
                        else
                            e.removeClass(this.settings.errorClass).removeClass(this.settings.validClass)
                    },
                    numberOfInvalids: function () {
                        return this.objectLength(this.invalid)
                    },
                    objectLength: function (e) {
                        var t, n = 0;
                        for (t in e)
                            e[t] && n++;
                        return n
                    },
                    hideErrors: function () {
                        this.hideThese(this.toHide)
                    },
                    hideThese: function (e) {
                        e.not(this.containers).text(""),
                            this.addWrapper(e).hide()
                    },
                    valid: function () {
                        return 0 === this.size()
                    },
                    size: function () {
                        return this.errorList.length
                    },
                    focusInvalid: function () {
                        if (this.settings.focusInvalid)
                            try {
                                c(this.findLastActive() || this.errorList.length && this.errorList[0].element || []).filter(":visible").focus().trigger("focusin")
                            } catch (e) {
                            }
                    },
                    findLastActive: function () {
                        var t = this.lastActive;
                        return t && 1 === c.grep(this.errorList, function (e) {
                            return e.element.name === t.name
                        }).length && t
                    },
                    elements: function () {
                        var t = this
                            , n = {};
                        return c(this.currentForm).find("input, select, textarea, [contenteditable]").not(":submit, :reset, :image, :disabled").not(this.settings.ignore).filter(function () {
                            var e = this.name || c(this).attr("name");
                            return !e && t.settings.debug && window.console && console.error("%o has no name assigned", this),
                            this.hasAttribute("contenteditable") && (this.form = c(this).closest("form")[0]),
                            !(e in n || !t.objectLength(c(this).rules())) && (n[e] = !0)
                        })
                    },
                    clean: function (e) {
                        return c(e)[0]
                    },
                    errors: function () {
                        var e = this.settings.errorClass.split(" ").join(".");
                        return c(this.settings.errorElement + "." + e, this.errorContext)
                    },
                    resetInternals: function () {
                        this.successList = [],
                            this.errorList = [],
                            this.errorMap = {},
                            this.toShow = c([]),
                            this.toHide = c([])
                    },
                    reset: function () {
                        this.resetInternals(),
                            this.currentElements = c([])
                    },
                    prepareForm: function () {
                        this.reset(),
                            this.toHide = this.errors().add(this.containers)
                    },
                    prepareElement: function (e) {
                        this.reset(),
                            this.toHide = this.errorsFor(e)
                    },
                    elementValue: function (e) {
                        var t, n, i = c(e), r = e.type;
                        return "radio" === r || "checkbox" === r ? this.findByName(e.name).filter(":checked").val() : "number" === r && void 0 !== e.validity ? e.validity.badInput ? "NaN" : i.val() : (t = e.hasAttribute("contenteditable") ? i.text() : i.val(),
                            "file" === r ? "C:\\fakepath\\" === t.substr(0, 12) ? t.substr(12) : 0 <= (n = t.lastIndexOf("/")) ? t.substr(n + 1) : 0 <= (n = t.lastIndexOf("\\")) ? t.substr(n + 1) : t : "string" == typeof t ? t.replace(/\r/g, "") : t)
                    },
                    check: function (t) {
                        t = this.validationTargetFor(this.clean(t));
                        var e, n, i, r = c(t).rules(), o = c.map(r, function (e, t) {
                            return t
                        }).length, s = !1, a = this.elementValue(t);
                        if ("function" == typeof r.normalizer) {
                            if ("string" != typeof (a = r.normalizer.call(t, a)))
                                throw new TypeError("The normalizer should return a string value.");
                            delete r.normalizer
                        }
                        for (n in r) {
                            i = {
                                method: n,
                                parameters: r[n]
                            };
                            try {
                                if ("dependency-mismatch" === (e = c.validator.methods[n].call(this, a, t, i.parameters)) && 1 === o) {
                                    s = !0;
                                    continue
                                }
                                if (s = !1,
                                "pending" === e)
                                    return void (this.toHide = this.toHide.not(this.errorsFor(t)));
                                if (!e)
                                    return this.formatAndAdd(t, i),
                                        !1
                            } catch (e) {
                                throw this.settings.debug && window.console && console.log("Exception occurred when checking element " + t.id + ", check the '" + i.method + "' method.", e),
                                e instanceof TypeError && (e.message += ".  Exception occurred when checking element " + t.id + ", check the '" + i.method + "' method."),
                                    e
                            }
                        }
                        if (!s)
                            return this.objectLength(r) && this.successList.push(t),
                                !0
                    },
                    customDataMessage: function (e, t) {
                        return c(e).data("msg" + t.charAt(0).toUpperCase() + t.substring(1).toLowerCase()) || c(e).data("msg")
                    },
                    customMessage: function (e, t) {
                        var n = this.settings.messages[e];
                        return n && (n.constructor === String ? n : n[t])
                    },
                    findDefined: function () {
                        for (var e = 0; e < arguments.length; e++)
                            if (void 0 !== arguments[e])
                                return arguments[e]
                    },
                    defaultMessage: function (e, t) {
                        var n = this.findDefined(this.customMessage(e.name, t.method), this.customDataMessage(e, t.method), !this.settings.ignoreTitle && e.title || void 0, c.validator.messages[t.method], "<strong>Warning: No message defined for " + e.name + "</strong>")
                            , i = /\$?\{(\d+)\}/g;
                        return "function" == typeof n ? n = n.call(this, t.parameters, e) : i.test(n) && (n = c.validator.format(n.replace(i, "{$1}"), t.parameters)),
                            n
                    },
                    formatAndAdd: function (e, t) {
                        var n = this.defaultMessage(e, t);
                        this.errorList.push({
                            message: n,
                            element: e,
                            method: t.method
                        }),
                            this.errorMap[e.name] = n,
                            this.submitted[e.name] = n
                    },
                    addWrapper: function (e) {
                        return this.settings.wrapper && (e = e.add(e.parent(this.settings.wrapper))),
                            e
                    },
                    defaultShowErrors: function () {
                        var e, t, n;
                        for (e = 0; this.errorList[e]; e++)
                            n = this.errorList[e],
                            this.settings.highlight && this.settings.highlight.call(this, n.element, this.settings.errorClass, this.settings.validClass),
                                this.showLabel(n.element, n.message);
                        if (this.errorList.length && (this.toShow = this.toShow.add(this.containers)),
                            this.settings.success)
                            for (e = 0; this.successList[e]; e++)
                                this.showLabel(this.successList[e]);
                        if (this.settings.unhighlight)
                            for (e = 0,
                                     t = this.validElements(); t[e]; e++)
                                this.settings.unhighlight.call(this, t[e], this.settings.errorClass, this.settings.validClass);
                        this.toHide = this.toHide.not(this.toShow),
                            this.hideErrors(),
                            this.addWrapper(this.toShow).show()
                    },
                    validElements: function () {
                        return this.currentElements.not(this.invalidElements())
                    },
                    invalidElements: function () {
                        return c(this.errorList).map(function () {
                            return this.element
                        })
                    },
                    showLabel: function (e, t) {
                        var n, i, r, o, s = this.errorsFor(e), a = this.idOrName(e), u = c(e).attr("aria-describedby");
                        s.length ? (s.removeClass(this.settings.validClass).addClass(this.settings.errorClass),
                            s.html(t)) : (n = s = c("<" + this.settings.errorElement + ">").attr("id", a + "-error").addClass(this.settings.errorClass).html(t || ""),
                        this.settings.wrapper && (n = s.hide().show().wrap("<" + this.settings.wrapper + "/>").parent()),
                            this.labelContainer.length ? this.labelContainer.append(n) : this.settings.errorPlacement ? this.settings.errorPlacement(n, c(e)) : n.insertAfter(e),
                            s.is("label") ? s.attr("for", a) : 0 === s.parents("label[for='" + this.escapeCssMeta(a) + "']").length && (r = s.attr("id"),
                                u ? u.match(new RegExp("\\b" + this.escapeCssMeta(r) + "\\b")) || (u += " " + r) : u = r,
                                c(e).attr("aria-describedby", u),
                            (i = this.groups[e.name]) && (o = this,
                                c.each(o.groups, function (e, t) {
                                    t === i && c("[name='" + o.escapeCssMeta(e) + "']", o.currentForm).attr("aria-describedby", s.attr("id"))
                                })))),
                        !t && this.settings.success && (s.text(""),
                            "string" == typeof this.settings.success ? s.addClass(this.settings.success) : this.settings.success(s, e)),
                            this.toShow = this.toShow.add(s)
                    },
                    errorsFor: function (e) {
                        var t = this.escapeCssMeta(this.idOrName(e))
                            , n = c(e).attr("aria-describedby")
                            , i = "label[for='" + t + "'], label[for='" + t + "'] *";
                        return n && (i = i + ", #" + this.escapeCssMeta(n).replace(/\s+/g, ", #")),
                            this.errors().filter(i)
                    },
                    escapeCssMeta: function (e) {
                        return e.replace(/([\\!"#$%&'()*+,./:;<=>?@\[\]^`{|}~])/g, "\\$1")
                    },
                    idOrName: function (e) {
                        return this.groups[e.name] || (this.checkable(e) ? e.name : e.id || e.name)
                    },
                    validationTargetFor: function (e) {
                        return this.checkable(e) && (e = this.findByName(e.name)),
                            c(e).not(this.settings.ignore)[0]
                    },
                    checkable: function (e) {
                        return /radio|checkbox/i.test(e.type)
                    },
                    findByName: function (e) {
                        return c(this.currentForm).find("[name='" + this.escapeCssMeta(e) + "']")
                    },
                    getLength: function (e, t) {
                        switch (t.nodeName.toLowerCase()) {
                            case "select":
                                return c("option:selected", t).length;
                            case "input":
                                if (this.checkable(t))
                                    return this.findByName(t.name).filter(":checked").length
                        }
                        return e.length
                    },
                    depend: function (e, t) {
                        return !this.dependTypes[typeof e] || this.dependTypes[typeof e](e, t)
                    },
                    dependTypes: {
                        boolean: function (e) {
                            return e
                        },
                        string: function (e, t) {
                            return !!c(e, t.form).length
                        },
                        function: function (e, t) {
                            return e(t)
                        }
                    },
                    optional: function (e) {
                        var t = this.elementValue(e);
                        return !c.validator.methods.required.call(this, t, e) && "dependency-mismatch"
                    },
                    startRequest: function (e) {
                        this.pending[e.name] || (this.pendingRequest++,
                            c(e).addClass(this.settings.pendingClass),
                            this.pending[e.name] = !0)
                    },
                    stopRequest: function (e, t) {
                        this.pendingRequest--,
                        this.pendingRequest < 0 && (this.pendingRequest = 0),
                            delete this.pending[e.name],
                            c(e).removeClass(this.settings.pendingClass),
                            t && 0 === this.pendingRequest && this.formSubmitted && this.form() ? (c(this.currentForm).submit(),
                                this.formSubmitted = !1) : !t && 0 === this.pendingRequest && this.formSubmitted && (c(this.currentForm).triggerHandler("invalid-form", [this]),
                                this.formSubmitted = !1)
                    },
                    previousValue: function (e, t) {
                        return c.data(e, "previousValue") || c.data(e, "previousValue", {
                            old: null,
                            valid: !0,
                            message: this.defaultMessage(e, {
                                method: t
                            })
                        })
                    },
                    destroy: function () {
                        this.resetForm(),
                            c(this.currentForm).off(".validate").removeData("validator").find(".validate-equalTo-blur").off(".validate-equalTo").removeClass("validate-equalTo-blur")
                    }
                },
                classRuleSettings: {
                    required: {
                        required: !0
                    },
                    email: {
                        email: !0
                    },
                    url: {
                        url: !0
                    },
                    date: {
                        date: !0
                    },
                    dateISO: {
                        dateISO: !0
                    },
                    number: {
                        number: !0
                    },
                    digits: {
                        digits: !0
                    },
                    creditcard: {
                        creditcard: !0
                    }
                },
                addClassRules: function (e, t) {
                    e.constructor === String ? this.classRuleSettings[e] = t : c.extend(this.classRuleSettings, e)
                },
                classRules: function (e) {
                    var t = {}
                        , n = c(e).attr("class");
                    return n && c.each(n.split(" "), function () {
                        this in c.validator.classRuleSettings && c.extend(t, c.validator.classRuleSettings[this])
                    }),
                        t
                },
                normalizeAttributeRule: function (e, t, n, i) {
                    /min|max|step/.test(n) && (null === t || /number|range|text/.test(t)) && (i = Number(i),
                    isNaN(i) && (i = void 0)),
                        i || 0 === i ? e[n] = i : t === n && "range" !== t && (e[n] = !0)
                },
                attributeRules: function (e) {
                    var t, n, i = {}, r = c(e), o = e.getAttribute("type");
                    for (t in c.validator.methods)
                        n = "required" === t ? ("" === (n = e.getAttribute(t)) && (n = !0),
                            !!n) : r.attr(t),
                            this.normalizeAttributeRule(i, o, t, n);
                    return i.maxlength && /-1|2147483647|524288/.test(i.maxlength) && delete i.maxlength,
                        i
                },
                dataRules: function (e) {
                    var t, n, i = {}, r = c(e), o = e.getAttribute("type");
                    for (t in c.validator.methods)
                        n = r.data("rule" + t.charAt(0).toUpperCase() + t.substring(1).toLowerCase()),
                            this.normalizeAttributeRule(i, o, t, n);
                    return i
                },
                staticRules: function (e) {
                    var t = {}
                        , n = c.data(e.form, "validator");
                    return n.settings.rules && (t = c.validator.normalizeRule(n.settings.rules[e.name]) || {}),
                        t
                },
                normalizeRules: function (i, r) {
                    return c.each(i, function (e, t) {
                        if (!1 !== t) {
                            if (t.param || t.depends) {
                                var n = !0;
                                switch (typeof t.depends) {
                                    case "string":
                                        n = !!c(t.depends, r.form).length;
                                        break;
                                    case "function":
                                        n = t.depends.call(r, r)
                                }
                                n ? i[e] = void 0 === t.param || t.param : (c.data(r.form, "validator").resetElements(c(r)),
                                    delete i[e])
                            }
                        } else
                            delete i[e]
                    }),
                        c.each(i, function (e, t) {
                            i[e] = c.isFunction(t) && "normalizer" !== e ? t(r) : t
                        }),
                        c.each(["minlength", "maxlength"], function () {
                            i[this] && (i[this] = Number(i[this]))
                        }),
                        c.each(["rangelength", "range"], function () {
                            var e;
                            i[this] && (c.isArray(i[this]) ? i[this] = [Number(i[this][0]), Number(i[this][1])] : "string" == typeof i[this] && (e = i[this].replace(/[\[\]]/g, "").split(/[\s,]+/),
                                i[this] = [Number(e[0]), Number(e[1])]))
                        }),
                    c.validator.autoCreateRanges && (null != i.min && null != i.max && (i.range = [i.min, i.max],
                        delete i.min,
                        delete i.max),
                    null != i.minlength && null != i.maxlength && (i.rangelength = [i.minlength, i.maxlength],
                        delete i.minlength,
                        delete i.maxlength)),
                        i
                },
                normalizeRule: function (e) {
                    if ("string" == typeof e) {
                        var t = {};
                        c.each(e.split(/\s/), function () {
                            t[this] = !0
                        }),
                            e = t
                    }
                    return e
                },
                addMethod: function (e, t, n) {
                    c.validator.methods[e] = t,
                        c.validator.messages[e] = void 0 !== n ? n : c.validator.messages[e],
                    t.length < 3 && c.validator.addClassRules(e, c.validator.normalizeRule(e))
                },
                methods: {
                    required: function (e, t, n) {
                        if (!this.depend(n, t))
                            return "dependency-mismatch";
                        if ("select" !== t.nodeName.toLowerCase())
                            return this.checkable(t) ? 0 < this.getLength(e, t) : 0 < e.length;
                        var i = c(t).val();
                        return i && 0 < i.length
                    },
                    email: function (e, t) {
                        return this.optional(t) || /^[a-zA-Z0-9.!#$%&'*+\/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$/.test(e)
                    },
                    url: function (e, t) {
                        return this.optional(t) || /^(?:(?:(?:https?|ftp):)?\/\/)(?:\S+(?::\S*)?@)?(?:(?!(?:10|127)(?:\.\d{1,3}){3})(?!(?:169\.254|192\.168)(?:\.\d{1,3}){2})(?!172\.(?:1[6-9]|2\d|3[0-1])(?:\.\d{1,3}){2})(?:[1-9]\d?|1\d\d|2[01]\d|22[0-3])(?:\.(?:1?\d{1,2}|2[0-4]\d|25[0-5])){2}(?:\.(?:[1-9]\d?|1\d\d|2[0-4]\d|25[0-4]))|(?:(?:[a-z\u00a1-\uffff0-9]-*)*[a-z\u00a1-\uffff0-9]+)(?:\.(?:[a-z\u00a1-\uffff0-9]-*)*[a-z\u00a1-\uffff0-9]+)*(?:\.(?:[a-z\u00a1-\uffff]{2,})).?)(?::\d{2,5})?(?:[/?#]\S*)?$/i.test(e)
                    },
                    date: function (e, t) {
                        return this.optional(t) || !/Invalid|NaN/.test(new Date(e).toString())
                    },
                    dateISO: function (e, t) {
                        return this.optional(t) || /^\d{4}[\/\-](0?[1-9]|1[012])[\/\-](0?[1-9]|[12][0-9]|3[01])$/.test(e)
                    },
                    number: function (e, t) {
                        return this.optional(t) || /^(?:-?\d+|-?\d{1,3}(?:,\d{3})+)?(?:\.\d+)?$/.test(e)
                    },
                    digits: function (e, t) {
                        return this.optional(t) || /^\d+$/.test(e)
                    },
                    minlength: function (e, t, n) {
                        var i = c.isArray(e) ? e.length : this.getLength(e, t);
                        return this.optional(t) || n <= i
                    },
                    maxlength: function (e, t, n) {
                        var i = c.isArray(e) ? e.length : this.getLength(e, t);
                        return this.optional(t) || i <= n
                    },
                    rangelength: function (e, t, n) {
                        var i = c.isArray(e) ? e.length : this.getLength(e, t);
                        return this.optional(t) || i >= n[0] && i <= n[1]
                    },
                    min: function (e, t, n) {
                        return this.optional(t) || n <= e
                    },
                    max: function (e, t, n) {
                        return this.optional(t) || e <= n
                    },
                    range: function (e, t, n) {
                        return this.optional(t) || e >= n[0] && e <= n[1]
                    },
                    step: function (e, t, n) {
                        var i = c(t).attr("type")
                            , r = "Step attribute on input type " + i + " is not supported."
                            , o = new RegExp("\\b" + i + "\\b");
                        if (i && !o.test(["text", "number", "range"].join()))
                            throw new Error(r);
                        return this.optional(t) || e % n == 0
                    },
                    equalTo: function (e, t, n) {
                        var i = c(n);
                        return this.settings.onfocusout && i.not(".validate-equalTo-blur").length && i.addClass("validate-equalTo-blur").on("blur.validate-equalTo", function () {
                            c(t).valid()
                        }),
                        e === i.val()
                    },
                    remote: function (o, s, e, a) {
                        if (this.optional(s))
                            return "dependency-mismatch";
                        a = "string" == typeof a && a || "remote";
                        var u, t, n, l = this.previousValue(s, a);
                        return this.settings.messages[s.name] || (this.settings.messages[s.name] = {}),
                            l.originalMessage = l.originalMessage || this.settings.messages[s.name][a],
                            this.settings.messages[s.name][a] = l.message,
                            e = "string" == typeof e && {
                                url: e
                            } || e,
                            n = c.param(c.extend({
                                data: o
                            }, e.data)),
                            l.old === n ? l.valid : (l.old = n,
                                (u = this).startRequest(s),
                                (t = {})[s.name] = o,
                                c.ajax(c.extend(!0, {
                                    mode: "abort",
                                    port: "validate" + s.name,
                                    dataType: "json",
                                    data: t,
                                    context: u.currentForm,
                                    success: function (e) {
                                        var t, n, i, r = !0 === e || "true" === e;
                                        u.settings.messages[s.name][a] = l.originalMessage,
                                            r ? (i = u.formSubmitted,
                                                u.resetInternals(),
                                                u.toHide = u.errorsFor(s),
                                                u.formSubmitted = i,
                                                u.successList.push(s),
                                                u.invalid[s.name] = !1,
                                                u.showErrors()) : (t = {},
                                                n = e || u.defaultMessage(s, {
                                                    method: a,
                                                    parameters: o
                                                }),
                                                t[s.name] = l.message = n,
                                                u.invalid[s.name] = !0,
                                                u.showErrors(t)),
                                            l.valid = r,
                                            u.stopRequest(s, r)
                                    }
                                }, e)),
                                "pending")
                    }
                }
            });
        var i, r = {};
        c.ajaxPrefilter ? c.ajaxPrefilter(function (e, t, n) {
            var i = e.port;
            "abort" === e.mode && (r[i] && r[i].abort(),
                r[i] = n)
        }) : (i = c.ajax,
                c.ajax = function (e) {
                    var t = ("mode" in e ? e : c.ajaxSettings).mode
                        , n = ("port" in e ? e : c.ajaxSettings).port;
                    return "abort" === t ? (r[n] && r[n].abort(),
                        r[n] = i.apply(this, arguments),
                        r[n]) : i.apply(this, arguments)
                }
        )
    }),
    function (r) {
        "use strict";
        var o = function (e, t) {
            this.el = r(e),
                this.options = r.extend({}, r.fn.typed.defaults, t),
                this.isInput = this.el.is("input"),
                this.attr = this.options.attr,
                this.showCursor = !this.isInput && this.options.showCursor,
                this.elContent = this.attr ? this.el.attr(this.attr) : this.el.text(),
                this.contentType = this.options.contentType,
                this.typeSpeed = this.options.typeSpeed,
                this.startDelay = this.options.startDelay,
                this.backSpeed = this.options.backSpeed,
                this.backDelay = this.options.backDelay,
                this.stringsElement = this.options.stringsElement,
                this.strings = this.options.strings,
                this.strPos = 0,
                this.arrayPos = 0,
                this.stopNum = 0,
                this.loop = this.options.loop,
                this.loopCount = this.options.loopCount,
                this.curLoop = 0,
                this.stop = !1,
                this.cursorChar = this.options.cursorChar,
                this.shuffle = this.options.shuffle,
                this.sequence = [],
                this.build()
        };
        o.prototype = {
            constructor: o,
            init: function () {
                var t = this;
                t.timeout = setTimeout(function () {
                    for (var e = 0; e < t.strings.length; ++e)
                        t.sequence[e] = e;
                    t.shuffle && (t.sequence = t.shuffleArray(t.sequence)),
                        t.typewrite(t.strings[t.sequence[t.arrayPos]], t.strPos)
                }, t.startDelay)
            },
            build: function () {
                var n = this;
                if (!0 === this.showCursor && (this.cursor = r('<span class="typed-cursor">' + this.cursorChar + "</span>"),
                    this.el.after(this.cursor)),
                    this.stringsElement) {
                    n.strings = [],
                        this.stringsElement.hide();
                    var e = this.stringsElement.find("p");
                    r.each(e, function (e, t) {
                        n.strings.push(r(t).html())
                    })
                }
                this.init()
            },
            typewrite: function (o, s) {
                if (!0 !== this.stop) {
                    var e = Math.round(70 * Math.random()) + this.typeSpeed
                        , a = this;
                    a.timeout = setTimeout(function () {
                        var e = 0
                            , t = o.substr(s);
                        if ("^" === t.charAt(0)) {
                            var n = 1;
                            /^\^\d+/.test(t) && (n += (t = /\d+/.exec(t)[0]).length,
                                e = parseInt(t)),
                                o = o.substring(0, s) + o.substring(s + n)
                        }
                        if ("html" === a.contentType) {
                            var i = o.substr(s).charAt(0);
                            if ("<" === i || "&" === i) {
                                var r = "";
                                for (r = "<" === i ? ">" : ";"; o.substr(s).charAt(0) !== r;)
                                    o.substr(s).charAt(0),
                                        s++;
                                s++,
                                    r
                            }
                        }
                        a.timeout = setTimeout(function () {
                            if (s === o.length) {
                                if (a.options.onStringTyped(a.arrayPos),
                                a.arrayPos === a.strings.length - 1 && (a.options.callback(),
                                    a.curLoop++,
                                !1 === a.loop || a.curLoop === a.loopCount))
                                    return;
                                a.timeout = setTimeout(function () {
                                    a.backspace(o, s)
                                }, a.backDelay)
                            } else {
                                0 === s && a.options.preStringTyped(a.arrayPos);
                                var e = o.substr(0, s + 1);
                                a.attr ? a.el.attr(a.attr, e) : a.isInput ? a.el.val(e) : "html" === a.contentType ? a.el.html(e) : a.el.text(e),
                                    s++,
                                    a.typewrite(o, s)
                            }
                        }, e)
                    }, e)
                }
            },
            backspace: function (t, n) {
                if (!0 !== this.stop) {
                    var e = Math.round(70 * Math.random()) + this.backSpeed
                        , i = this;
                    i.timeout = setTimeout(function () {
                        if ("html" === i.contentType && ">" === t.substr(n).charAt(0)) {
                            for (; "<" !== t.substr(n).charAt(0);)
                                t.substr(n).charAt(0),
                                    n--;
                            n--,
                                "<"
                        }
                        var e = t.substr(0, n);
                        i.attr ? i.el.attr(i.attr, e) : i.isInput ? i.el.val(e) : "html" === i.contentType ? i.el.html(e) : i.el.text(e),
                            n > i.stopNum ? (n--,
                                i.backspace(t, n)) : n <= i.stopNum && (i.arrayPos++,
                                i.arrayPos === i.strings.length ? (i.arrayPos = 0,
                                i.shuffle && (i.sequence = i.shuffleArray(i.sequence)),
                                    i.init()) : i.typewrite(i.strings[i.sequence[i.arrayPos]], n))
                    }, e)
                }
            },
            shuffleArray: function (e) {
                var t, n, i = e.length;
                if (i)
                    for (; --i;)
                        t = e[n = Math.floor(Math.random() * (i + 1))],
                            e[n] = e[i],
                            e[i] = t;
                return e
            },
            reset: function () {
                clearInterval(this.timeout);
                var e = this.el.attr("id");
                this.el.after('<span id="' + e + '"/>'),
                    this.el.remove(),
                void 0 !== this.cursor && this.cursor.remove(),
                    this.options.resetCallback()
            }
        },
            r.fn.typed = function (i) {
                return this.each(function () {
                    var e = r(this)
                        , t = e.data("typed")
                        , n = "object" == typeof i && i;
                    t || e.data("typed", t = new o(this, n)),
                    "string" == typeof i && t[i]()
                })
            }
            ,
            r.fn.typed.defaults = {
                strings: ["These are the default values...", "You know what you should do?", "Use your own!", "Have a great day!"],
                stringsElement: null,
                typeSpeed: 0,
                startDelay: 0,
                backSpeed: 0,
                shuffle: !1,
                backDelay: 500,
                loop: !1,
                loopCount: !1,
                showCursor: !0,
                cursorChar: "|",
                attr: null,
                contentType: "html",
                callback: function () {
                },
                preStringTyped: function () {
                },
                onStringTyped: function () {
                },
                resetCallback: function () {
                }
            }
    }(window.jQuery),
    function (e) {
        "function" == typeof define && define.amd ? define(["jquery"], e) : "object" == typeof exports ? e(require("jquery")) : e(window.jQuery || window.Zepto)
    }(function (c) {
        var d, i, h, r, f, t, u = "Close", l = "BeforeClose", p = "MarkupParse", m = "Open", g = ".mfp",
            v = "mfp-ready", n = "mfp-removing", s = "mfp-prevent-close", e = function () {
            }, a = !!window.jQuery, y = c(window), b = function (e, t) {
                d.ev.on("mfp" + e + g, t)
            }, x = function (e, t, n, i) {
                var r = document.createElement("div");
                return r.className = "mfp-" + e,
                n && (r.innerHTML = n),
                    i ? t && t.appendChild(r) : (r = c(r),
                    t && r.appendTo(t)),
                    r
            }, w = function (e, t) {
                d.ev.triggerHandler("mfp" + e, t),
                d.st.callbacks && (e = e.charAt(0).toLowerCase() + e.slice(1),
                d.st.callbacks[e] && d.st.callbacks[e].apply(d, c.isArray(t) ? t : [t]))
            }, C = function (e) {
                return e === t && d.currTemplate.closeBtn || (d.currTemplate.closeBtn = c(d.st.closeMarkup.replace("%title%", d.st.tClose)),
                    t = e),
                    d.currTemplate.closeBtn
            }, o = function () {
                c.magnificPopup.instance || ((d = new e).init(),
                    c.magnificPopup.instance = d)
            };
        e.prototype = {
            constructor: e,
            init: function () {
                var e = navigator.appVersion;
                d.isLowIE = d.isIE8 = document.all && !document.addEventListener,
                    d.isAndroid = /android/gi.test(e),
                    d.isIOS = /iphone|ipad|ipod/gi.test(e),
                    d.supportsTransition = function () {
                        var e = document.createElement("p").style
                            , t = ["ms", "O", "Moz", "Webkit"];
                        if (void 0 !== e.transition)
                            return !0;
                        for (; t.length;)
                            if (t.pop() + "Transition" in e)
                                return !0;
                        return !1
                    }(),
                    d.probablyMobile = d.isAndroid || d.isIOS || /(Opera Mini)|Kindle|webOS|BlackBerry|(Opera Mobi)|(Windows Phone)|IEMobile/i.test(navigator.userAgent),
                    h = c(document),
                    d.popupsCache = {}
            },
            open: function (e) {
                var t;
                if (!1 === e.isObj) {
                    d.items = e.items.toArray(),
                        d.index = 0;
                    var n, i = e.items;
                    for (t = 0; t < i.length; t++)
                        if ((n = i[t]).parsed && (n = n.el[0]),
                        n === e.el[0]) {
                            d.index = t;
                            break
                        }
                } else
                    d.items = c.isArray(e.items) ? e.items : [e.items],
                        d.index = e.index || 0;
                if (!d.isOpen) {
                    d.types = [],
                        f = "",
                        e.mainEl && e.mainEl.length ? d.ev = e.mainEl.eq(0) : d.ev = h,
                        e.key ? (d.popupsCache[e.key] || (d.popupsCache[e.key] = {}),
                            d.currTemplate = d.popupsCache[e.key]) : d.currTemplate = {},
                        d.st = c.extend(!0, {}, c.magnificPopup.defaults, e),
                        d.fixedContentPos = "auto" === d.st.fixedContentPos ? !d.probablyMobile : d.st.fixedContentPos,
                    d.st.modal && (d.st.closeOnContentClick = !1,
                        d.st.closeOnBgClick = !1,
                        d.st.showCloseBtn = !1,
                        d.st.enableEscapeKey = !1),
                    d.bgOverlay || (d.bgOverlay = x("bg").on("click" + g, function () {
                        d.close()
                    }),
                        d.wrap = x("wrap").attr("tabindex", -1).on("click" + g, function (e) {
                            d._checkIfClose(e.target) && d.close()
                        }),
                        d.container = x("container", d.wrap)),
                        d.contentContainer = x("content"),
                    d.st.preloader && (d.preloader = x("preloader", d.container, d.st.tLoading));
                    var r = c.magnificPopup.modules;
                    for (t = 0; t < r.length; t++) {
                        var o = r[t];
                        o = o.charAt(0).toUpperCase() + o.slice(1),
                            d["init" + o].call(d)
                    }
                    w("BeforeOpen"),
                    d.st.showCloseBtn && (d.st.closeBtnInside ? (b(p, function (e, t, n, i) {
                        n.close_replaceWith = C(i.type)
                    }),
                        f += " mfp-close-btn-in") : d.wrap.append(C())),
                    d.st.alignTop && (f += " mfp-align-top"),
                        d.fixedContentPos ? d.wrap.css({
                            overflow: d.st.overflowY,
                            overflowX: "hidden",
                            overflowY: d.st.overflowY
                        }) : d.wrap.css({
                            top: y.scrollTop(),
                            position: "absolute"
                        }),
                    (!1 === d.st.fixedBgPos || "auto" === d.st.fixedBgPos && !d.fixedContentPos) && d.bgOverlay.css({
                        height: h.height(),
                        position: "absolute"
                    }),
                    d.st.enableEscapeKey && h.on("keyup" + g, function (e) {
                        27 === e.keyCode && d.close()
                    }),
                        y.on("resize" + g, function () {
                            d.updateSize()
                        }),
                    d.st.closeOnContentClick || (f += " mfp-auto-cursor"),
                    f && d.wrap.addClass(f);
                    var s = d.wH = y.height()
                        , a = {};
                    if (d.fixedContentPos && d._hasScrollBar(s)) {
                        var u = d._getScrollbarSize();
                        u && (a.marginRight = u)
                    }
                    d.fixedContentPos && (d.isIE7 ? c("body, html").css("overflow", "hidden") : a.overflow = "hidden");
                    var l = d.st.mainClass;
                    return d.isIE7 && (l += " mfp-ie7"),
                    l && d._addClassToMFP(l),
                        d.updateItemHTML(),
                        w("BuildControls"),
                        c("html").css(a),
                        d.bgOverlay.add(d.wrap).prependTo(d.st.prependTo || c(document.body)),
                        d._lastFocusedEl = document.activeElement,
                        setTimeout(function () {
                            d.content ? (d._addClassToMFP(v),
                                d._setFocus()) : d.bgOverlay.addClass(v),
                                h.on("focusin" + g, d._onFocusIn)
                        }, 16),
                        d.isOpen = !0,
                        d.updateSize(s),
                        w(m),
                        e
                }
                d.updateItemHTML()
            },
            close: function () {
                d.isOpen && (w(l),
                    d.isOpen = !1,
                    d.st.removalDelay && !d.isLowIE && d.supportsTransition ? (d._addClassToMFP(n),
                        setTimeout(function () {
                            d._close()
                        }, d.st.removalDelay)) : d._close())
            },
            _close: function () {
                w(u);
                var e = n + " " + v + " ";
                if (d.bgOverlay.detach(),
                    d.wrap.detach(),
                    d.container.empty(),
                d.st.mainClass && (e += d.st.mainClass + " "),
                    d._removeClassFromMFP(e),
                    d.fixedContentPos) {
                    var t = {
                        marginRight: ""
                    };
                    d.isIE7 ? c("body, html").css("overflow", "") : t.overflow = "",
                        c("html").css(t)
                }
                h.off("keyup.mfp focusin" + g),
                    d.ev.off(g),
                    d.wrap.attr("class", "mfp-wrap").removeAttr("style"),
                    d.bgOverlay.attr("class", "mfp-bg"),
                    d.container.attr("class", "mfp-container"),
                !d.st.showCloseBtn || d.st.closeBtnInside && !0 !== d.currTemplate[d.currItem.type] || d.currTemplate.closeBtn && d.currTemplate.closeBtn.detach(),
                d.st.autoFocusLast && d._lastFocusedEl && c(d._lastFocusedEl).focus(),
                    d.currItem = null,
                    d.content = null,
                    d.currTemplate = null,
                    d.prevHeight = 0,
                    w("AfterClose")
            },
            updateSize: function (e) {
                if (d.isIOS) {
                    var t = document.documentElement.clientWidth / window.innerWidth
                        , n = window.innerHeight * t;
                    d.wrap.css("height", n),
                        d.wH = n
                } else
                    d.wH = e || y.height();
                d.fixedContentPos || d.wrap.css("height", d.wH),
                    w("Resize")
            },
            updateItemHTML: function () {
                var e = d.items[d.index];
                d.contentContainer.detach(),
                d.content && d.content.detach(),
                e.parsed || (e = d.parseEl(d.index));
                var t = e.type;
                if (w("BeforeChange", [d.currItem ? d.currItem.type : "", t]),
                    d.currItem = e,
                    !d.currTemplate[t]) {
                    var n = !!d.st[t] && d.st[t].markup;
                    w("FirstMarkupParse", n),
                        d.currTemplate[t] = !n || c(n)
                }
                r && r !== e.type && d.container.removeClass("mfp-" + r + "-holder");
                var i = d["get" + t.charAt(0).toUpperCase() + t.slice(1)](e, d.currTemplate[t]);
                d.appendContent(i, t),
                    e.preloaded = !0,
                    w("Change", e),
                    r = e.type,
                    d.container.prepend(d.contentContainer),
                    w("AfterChange")
            },
            appendContent: function (e, t) {
                (d.content = e) ? d.st.showCloseBtn && d.st.closeBtnInside && !0 === d.currTemplate[t] ? d.content.find(".mfp-close").length || d.content.append(C()) : d.content = e : d.content = "",
                    w("BeforeAppend"),
                    d.container.addClass("mfp-" + t + "-holder"),
                    d.contentContainer.append(d.content)
            },
            parseEl: function (e) {
                var t, n = d.items[e];
                if ((n = n.tagName ? {
                    el: c(n)
                } : (t = n.type,
                    {
                        data: n,
                        src: n.src
                    })).el) {
                    for (var i = d.types, r = 0; r < i.length; r++)
                        if (n.el.hasClass("mfp-" + i[r])) {
                            t = i[r];
                            break
                        }
                    n.src = n.el.attr("data-mfp-src"),
                    n.src || (n.src = n.el.attr("href"))
                }
                return n.type = t || d.st.type || "inline",
                    n.index = e,
                    n.parsed = !0,
                    d.items[e] = n,
                    w("ElementParse", n),
                    d.items[e]
            },
            addGroup: function (t, n) {
                var e = function (e) {
                    e.mfpEl = this,
                        d._openClick(e, t, n)
                };
                n || (n = {});
                var i = "click.magnificPopup";
                n.mainEl = t,
                    n.items ? (n.isObj = !0,
                        t.off(i).on(i, e)) : (n.isObj = !1,
                        n.delegate ? t.off(i).on(i, n.delegate, e) : (n.items = t).off(i).on(i, e))
            },
            _openClick: function (e, t, n) {
                if ((void 0 !== n.midClick ? n.midClick : c.magnificPopup.defaults.midClick) || !(2 === e.which || e.ctrlKey || e.metaKey || e.altKey || e.shiftKey)) {
                    var i = void 0 !== n.disableOn ? n.disableOn : c.magnificPopup.defaults.disableOn;
                    if (i)
                        if (c.isFunction(i)) {
                            if (!i.call(d))
                                return !0
                        } else if (y.width() < i)
                            return !0;
                    e.type && (e.preventDefault(),
                    d.isOpen && e.stopPropagation()),
                        n.el = c(e.mfpEl),
                    n.delegate && (n.items = t.find(n.delegate)),
                        d.open(n)
                }
            },
            updateStatus: function (e, t) {
                if (d.preloader) {
                    i !== e && d.container.removeClass("mfp-s-" + i),
                    t || "loading" !== e || (t = d.st.tLoading);
                    var n = {
                        status: e,
                        text: t
                    };
                    w("UpdateStatus", n),
                        e = n.status,
                        t = n.text,
                        d.preloader.html(t),
                        d.preloader.find("a").on("click", function (e) {
                            e.stopImmediatePropagation()
                        }),
                        d.container.addClass("mfp-s-" + e),
                        i = e
                }
            },
            _checkIfClose: function (e) {
                if (!c(e).hasClass(s)) {
                    var t = d.st.closeOnContentClick
                        , n = d.st.closeOnBgClick;
                    if (t && n)
                        return !0;
                    if (!d.content || c(e).hasClass("mfp-close") || d.preloader && e === d.preloader[0])
                        return !0;
                    if (e === d.content[0] || c.contains(d.content[0], e)) {
                        if (t)
                            return !0
                    } else if (n && c.contains(document, e))
                        return !0;
                    return !1
                }
            },
            _addClassToMFP: function (e) {
                d.bgOverlay.addClass(e),
                    d.wrap.addClass(e)
            },
            _removeClassFromMFP: function (e) {
                this.bgOverlay.removeClass(e),
                    d.wrap.removeClass(e)
            },
            _hasScrollBar: function (e) {
                return (d.isIE7 ? h.height() : document.body.scrollHeight) > (e || y.height())
            },
            _setFocus: function () {
                (d.st.focus ? d.content.find(d.st.focus).eq(0) : d.wrap).focus()
            },
            _onFocusIn: function (e) {
                if (e.target !== d.wrap[0] && !c.contains(d.wrap[0], e.target))
                    return d._setFocus(),
                        !1
            },
            _parseMarkup: function (r, e, t) {
                var o;
                t.data && (e = c.extend(t.data, e)),
                    w(p, [r, e, t]),
                    c.each(e, function (e, t) {
                        if (void 0 === t || !1 === t)
                            return !0;
                        if (1 < (o = e.split("_")).length) {
                            var n = r.find(g + "-" + o[0]);
                            if (0 < n.length) {
                                var i = o[1];
                                "replaceWith" === i ? n[0] !== t[0] && n.replaceWith(t) : "img" === i ? n.is("img") ? n.attr("src", t) : n.replaceWith(c("<img>").attr("src", t).attr("class", n.attr("class"))) : n.attr(o[1], t)
                            }
                        } else
                            r.find(g + "-" + e).html(t)
                    })
            },
            _getScrollbarSize: function () {
                if (void 0 === d.scrollbarSize) {
                    var e = document.createElement("div");
                    e.style.cssText = "width: 99px; height: 99px; overflow: scroll; position: absolute; top: -9999px;",
                        document.body.appendChild(e),
                        d.scrollbarSize = e.offsetWidth - e.clientWidth,
                        document.body.removeChild(e)
                }
                return d.scrollbarSize
            }
        },
            c.magnificPopup = {
                instance: null,
                proto: e.prototype,
                modules: [],
                open: function (e, t) {
                    return o(),
                        (e = e ? c.extend(!0, {}, e) : {}).isObj = !0,
                        e.index = t || 0,
                        this.instance.open(e)
                },
                close: function () {
                    return c.magnificPopup.instance && c.magnificPopup.instance.close()
                },
                registerModule: function (e, t) {
                    t.options && (c.magnificPopup.defaults[e] = t.options),
                        c.extend(this.proto, t.proto),
                        this.modules.push(e)
                },
                defaults: {
                    disableOn: 0,
                    key: null,
                    midClick: !1,
                    mainClass: "",
                    preloader: !0,
                    focus: "",
                    closeOnContentClick: !1,
                    closeOnBgClick: !0,
                    closeBtnInside: !0,
                    showCloseBtn: !0,
                    enableEscapeKey: !0,
                    modal: !1,
                    alignTop: !1,
                    removalDelay: 0,
                    prependTo: null,
                    fixedContentPos: "auto",
                    fixedBgPos: "auto",
                    overflowY: "auto",
                    closeMarkup: '<button title="%title%" type="button" class="mfp-close">&#215;</button>',
                    tClose: "Close (Esc)",
                    tLoading: "Loading...",
                    autoFocusLast: !0
                }
            },
            c.fn.magnificPopup = function (e) {
                o();
                var t = c(this);
                if ("string" == typeof e)
                    if ("open" === e) {
                        var n, i = a ? t.data("magnificPopup") : t[0].magnificPopup,
                            r = parseInt(arguments[1], 10) || 0;
                        n = i.items ? i.items[r] : (n = t,
                        i.delegate && (n = n.find(i.delegate)),
                            n.eq(r)),
                            d._openClick({
                                mfpEl: n
                            }, t, i)
                    } else
                        d.isOpen && d[e].apply(d, Array.prototype.slice.call(arguments, 1));
                else
                    e = c.extend(!0, {}, e),
                        a ? t.data("magnificPopup", e) : t[0].magnificPopup = e,
                        d.addGroup(t, e);
                return t
            }
        ;
        var T, E, k, S = "inline", I = function () {
            k && (E.after(k.addClass(T)).detach(),
                k = null)
        };
        c.magnificPopup.registerModule(S, {
            options: {
                hiddenClass: "hide",
                markup: "",
                tNotFound: "Content not found"
            },
            proto: {
                initInline: function () {
                    d.types.push(S),
                        b(u + "." + S, function () {
                            I()
                        })
                },
                getInline: function (e, t) {
                    if (I(),
                        e.src) {
                        var n = d.st.inline
                            , i = c(e.src);
                        if (i.length) {
                            var r = i[0].parentNode;
                            r && r.tagName && (E || (T = n.hiddenClass,
                                E = x(T),
                                T = "mfp-" + T),
                                k = i.after(E).detach().removeClass(T)),
                                d.updateStatus("ready")
                        } else
                            d.updateStatus("error", n.tNotFound),
                                i = c("<div>");
                        return e.inlineElement = i
                    }
                    return d.updateStatus("ready"),
                        d._parseMarkup(t, {}, e),
                        t
                }
            }
        });
        var L, N = "ajax", A = function () {
            L && c(document.body).removeClass(L)
        }, _ = function () {
            A(),
            d.req && d.req.abort()
        };
        c.magnificPopup.registerModule(N, {
            options: {
                settings: null,
                cursor: "mfp-ajax-cur",
                tError: '<a href="%url%">The content</a> could not be loaded.'
            },
            proto: {
                initAjax: function () {
                    d.types.push(N),
                        L = d.st.ajax.cursor,
                        b(u + "." + N, _),
                        b("BeforeChange." + N, _)
                },
                getAjax: function (r) {
                    L && c(document.body).addClass(L),
                        d.updateStatus("loading");
                    var e = c.extend({
                        url: r.src,
                        success: function (e, t, n) {
                            var i = {
                                data: e,
                                xhr: n
                            };
                            w("ParseAjax", i),
                                d.appendContent(c(i.data), N),
                                r.finished = !0,
                                A(),
                                d._setFocus(),
                                setTimeout(function () {
                                    d.wrap.addClass(v)
                                }, 16),
                                d.updateStatus("ready"),
                                w("AjaxContentAdded")
                        },
                        error: function () {
                            A(),
                                r.finished = r.loadError = !0,
                                d.updateStatus("error", d.st.ajax.tError.replace("%url%", r.src))
                        }
                    }, d.st.ajax.settings);
                    return d.req = c.ajax(e),
                        ""
                }
            }
        });
        var j;
        c.magnificPopup.registerModule("image", {
            options: {
                markup: '<div class="mfp-figure"><div class="mfp-close"></div><figure><div class="mfp-img"></div><figcaption><div class="mfp-bottom-bar"><div class="mfp-title"></div><div class="mfp-counter"></div></div></figcaption></figure></div>',
                cursor: "mfp-zoom-out-cur",
                titleSrc: "title",
                verticalFit: !0,
                tError: '<a href="%url%">The image</a> could not be loaded.'
            },
            proto: {
                initImage: function () {
                    var e = d.st.image
                        , t = ".image";
                    d.types.push("image"),
                        b(m + t, function () {
                            "image" === d.currItem.type && e.cursor && c(document.body).addClass(e.cursor)
                        }),
                        b(u + t, function () {
                            e.cursor && c(document.body).removeClass(e.cursor),
                                y.off("resize" + g)
                        }),
                        b("Resize" + t, d.resizeImage),
                    d.isLowIE && b("AfterChange", d.resizeImage)
                },
                resizeImage: function () {
                    var e = d.currItem;
                    if (e && e.img && d.st.image.verticalFit) {
                        var t = 0;
                        d.isLowIE && (t = parseInt(e.img.css("padding-top"), 10) + parseInt(e.img.css("padding-bottom"), 10)),
                            e.img.css("max-height", d.wH - t)
                    }
                },
                _onImageHasSize: function (e) {
                    e.img && (e.hasSize = !0,
                    j && clearInterval(j),
                        e.isCheckingImgSize = !1,
                        w("ImageHasSize", e),
                    e.imgHidden && (d.content && d.content.removeClass("mfp-loading"),
                        e.imgHidden = !1))
                },
                findImageSize: function (t) {
                    var n = 0
                        , i = t.img[0]
                        , r = function (e) {
                        j && clearInterval(j),
                            j = setInterval(function () {
                                0 < i.naturalWidth ? d._onImageHasSize(t) : (200 < n && clearInterval(j),
                                    3 === ++n ? r(10) : 40 === n ? r(50) : 100 === n && r(500))
                            }, e)
                    };
                    r(1)
                },
                getImage: function (e, t) {
                    var n = 0
                        , i = function () {
                        e && (e.img[0].complete ? (e.img.off(".mfploader"),
                        e === d.currItem && (d._onImageHasSize(e),
                            d.updateStatus("ready")),
                            e.hasSize = !0,
                            e.loaded = !0,
                            w("ImageLoadComplete")) : ++n < 200 ? setTimeout(i, 100) : r())
                    }
                        , r = function () {
                        e && (e.img.off(".mfploader"),
                        e === d.currItem && (d._onImageHasSize(e),
                            d.updateStatus("error", o.tError.replace("%url%", e.src))),
                            e.hasSize = !0,
                            e.loaded = !0,
                            e.loadError = !0)
                    }
                        , o = d.st.image
                        , s = t.find(".mfp-img");
                    if (s.length) {
                        var a = document.createElement("img");
                        a.className = "mfp-img",
                        e.el && e.el.find("img").length && (a.alt = e.el.find("img").attr("alt")),
                            e.img = c(a).on("load.mfploader", i).on("error.mfploader", r),
                            a.src = e.src,
                        s.is("img") && (e.img = e.img.clone()),
                            0 < (a = e.img[0]).naturalWidth ? e.hasSize = !0 : a.width || (e.hasSize = !1)
                    }
                    return d._parseMarkup(t, {
                        title: function (e) {
                            if (e.data && void 0 !== e.data.title)
                                return e.data.title;
                            var t = d.st.image.titleSrc;
                            if (t) {
                                if (c.isFunction(t))
                                    return t.call(d, e);
                                if (e.el)
                                    return e.el.attr(t) || ""
                            }
                            return ""
                        }(e),
                        img_replaceWith: e.img
                    }, e),
                        d.resizeImage(),
                        e.hasSize ? (j && clearInterval(j),
                            e.loadError ? (t.addClass("mfp-loading"),
                                d.updateStatus("error", o.tError.replace("%url%", e.src))) : (t.removeClass("mfp-loading"),
                                d.updateStatus("ready"))) : (d.updateStatus("loading"),
                            e.loading = !0,
                        e.hasSize || (e.imgHidden = !0,
                            t.addClass("mfp-loading"),
                            d.findImageSize(e))),
                        t
                }
            }
        });
        var q;
        c.magnificPopup.registerModule("zoom", {
            options: {
                enabled: !1,
                easing: "ease-in-out",
                duration: 300,
                opener: function (e) {
                    return e.is("img") ? e : e.find("img")
                }
            },
            proto: {
                initZoom: function () {
                    var e, o = d.st.zoom, t = ".zoom";
                    if (o.enabled && d.supportsTransition) {
                        var n, i, r = o.duration, s = function (e) {
                            var t = e.clone().removeAttr("style").removeAttr("class").addClass("mfp-animated-image")
                                , n = "all " + o.duration / 1e3 + "s " + o.easing
                                , i = {
                                position: "fixed",
                                zIndex: 9999,
                                left: 0,
                                top: 0,
                                "-webkit-backface-visibility": "hidden"
                            }
                                , r = "transition";
                            return i["-webkit-" + r] = i["-moz-" + r] = i["-o-" + r] = i[r] = n,
                                t.css(i),
                                t
                        }, a = function () {
                            d.content.css("visibility", "visible")
                        };
                        b("BuildControls" + t, function () {
                            if (d._allowZoom()) {
                                if (clearTimeout(n),
                                    d.content.css("visibility", "hidden"),
                                    !(e = d._getItemToZoom()))
                                    return void a();
                                (i = s(e)).css(d._getOffset()),
                                    d.wrap.append(i),
                                    n = setTimeout(function () {
                                        i.css(d._getOffset(!0)),
                                            n = setTimeout(function () {
                                                a(),
                                                    setTimeout(function () {
                                                        i.remove(),
                                                            e = i = null,
                                                            w("ZoomAnimationEnded")
                                                    }, 16)
                                            }, r)
                                    }, 16)
                            }
                        }),
                            b(l + t, function () {
                                if (d._allowZoom()) {
                                    if (clearTimeout(n),
                                        d.st.removalDelay = r,
                                        !e) {
                                        if (!(e = d._getItemToZoom()))
                                            return;
                                        i = s(e)
                                    }
                                    i.css(d._getOffset(!0)),
                                        d.wrap.append(i),
                                        d.content.css("visibility", "hidden"),
                                        setTimeout(function () {
                                            i.css(d._getOffset())
                                        }, 16)
                                }
                            }),
                            b(u + t, function () {
                                d._allowZoom() && (a(),
                                i && i.remove(),
                                    e = null)
                            })
                    }
                },
                _allowZoom: function () {
                    return "image" === d.currItem.type
                },
                _getItemToZoom: function () {
                    return !!d.currItem.hasSize && d.currItem.img
                },
                _getOffset: function (e) {
                    var t, n = (t = e ? d.currItem.img : d.st.zoom.opener(d.currItem.el || d.currItem)).offset(),
                        i = parseInt(t.css("padding-top"), 10), r = parseInt(t.css("padding-bottom"), 10);
                    n.top -= c(window).scrollTop() - i;
                    var o = {
                        width: t.width(),
                        height: (a ? t.innerHeight() : t[0].offsetHeight) - r - i
                    };
                    return void 0 === q && (q = void 0 !== document.createElement("p").style.MozTransform),
                        q ? o["-moz-transform"] = o.transform = "translate(" + n.left + "px," + n.top + "px)" : (o.left = n.left,
                            o.top = n.top),
                        o
                }
            }
        });
        var O = "iframe"
            , z = function (e) {
            if (d.currTemplate[O]) {
                var t = d.currTemplate[O].find("iframe");
                t.length && (e || (t[0].src = "//about:blank"),
                d.isIE8 && t.css("display", e ? "block" : "none"))
            }
        };
        c.magnificPopup.registerModule(O, {
            options: {
                markup: '<div class="mfp-iframe-scaler"><div class="mfp-close"></div><iframe class="mfp-iframe" src="//about:blank" frameborder="0" allowfullscreen></iframe></div>',
                srcAction: "iframe_src",
                patterns: {
                    youtube: {
                        index: "youtube.com",
                        id: "v=",
                        src: "//www.youtube.com/embed/%id%?autoplay=1"
                    },
                    vimeo: {
                        index: "vimeo.com/",
                        id: "/",
                        src: "//player.vimeo.com/video/%id%?autoplay=1"
                    },
                    gmaps: {
                        index: "//maps.google.",
                        src: "%id%&output=embed"
                    }
                }
            },
            proto: {
                initIframe: function () {
                    d.types.push(O),
                        b("BeforeChange", function (e, t, n) {
                            t !== n && (t === O ? z() : n === O && z(!0))
                        }),
                        b(u + "." + O, function () {
                            z()
                        })
                },
                getIframe: function (e, t) {
                    var n = e.src
                        , i = d.st.iframe;
                    c.each(i.patterns, function () {
                        if (-1 < n.indexOf(this.index))
                            return this.id && (n = "string" == typeof this.id ? n.substr(n.lastIndexOf(this.id) + this.id.length, n.length) : this.id.call(this, n)),
                                n = this.src.replace("%id%", n),
                                !1
                    });
                    var r = {};
                    return i.srcAction && (r[i.srcAction] = n),
                        d._parseMarkup(t, r, e),
                        d.updateStatus("ready"),
                        t
                }
            }
        });
        var P = function (e) {
            var t = d.items.length;
            return t - 1 < e ? e - t : e < 0 ? t + e : e
        }
            , D = function (e, t, n) {
            return e.replace(/%curr%/gi, t + 1).replace(/%total%/gi, n)
        };
        c.magnificPopup.registerModule("gallery", {
            options: {
                enabled: !1,
                arrowMarkup: '<button title="%title%" type="button" class="mfp-arrow mfp-arrow-%dir%"></button>',
                preload: [0, 2],
                navigateByImgClick: !0,
                arrows: !0,
                tPrev: "Previous (Left arrow key)",
                tNext: "Next (Right arrow key)",
                tCounter: "%curr% of %total%"
            },
            proto: {
                initGallery: function () {
                    var o = d.st.gallery
                        , e = ".mfp-gallery";
                    if (d.direction = !0,
                    !o || !o.enabled)
                        return !1;
                    f += " mfp-gallery",
                        b(m + e, function () {
                            o.navigateByImgClick && d.wrap.on("click" + e, ".mfp-img", function () {
                                if (1 < d.items.length)
                                    return d.next(),
                                        !1
                            }),
                                h.on("keydown" + e, function (e) {
                                    37 === e.keyCode ? d.prev() : 39 === e.keyCode && d.next()
                                })
                        }),
                        b("UpdateStatus" + e, function (e, t) {
                            t.text && (t.text = D(t.text, d.currItem.index, d.items.length))
                        }),
                        b(p + e, function (e, t, n, i) {
                            var r = d.items.length;
                            n.counter = 1 < r ? D(o.tCounter, i.index, r) : ""
                        }),
                        b("BuildControls" + e, function () {
                            if (1 < d.items.length && o.arrows && !d.arrowLeft) {
                                var e = o.arrowMarkup
                                    ,
                                    t = d.arrowLeft = c(e.replace(/%title%/gi, o.tPrev).replace(/%dir%/gi, "left")).addClass(s)
                                    ,
                                    n = d.arrowRight = c(e.replace(/%title%/gi, o.tNext).replace(/%dir%/gi, "right")).addClass(s);
                                t.click(function () {
                                    d.prev()
                                }),
                                    n.click(function () {
                                        d.next()
                                    }),
                                    d.container.append(t.add(n))
                            }
                        }),
                        b("Change" + e, function () {
                            d._preloadTimeout && clearTimeout(d._preloadTimeout),
                                d._preloadTimeout = setTimeout(function () {
                                    d.preloadNearbyImages(),
                                        d._preloadTimeout = null
                                }, 16)
                        }),
                        b(u + e, function () {
                            h.off(e),
                                d.wrap.off("click" + e),
                                d.arrowRight = d.arrowLeft = null
                        })
                },
                next: function () {
                    d.direction = !0,
                        d.index = P(d.index + 1),
                        d.updateItemHTML()
                },
                prev: function () {
                    d.direction = !1,
                        d.index = P(d.index - 1),
                        d.updateItemHTML()
                },
                goTo: function (e) {
                    d.direction = e >= d.index,
                        d.index = e,
                        d.updateItemHTML()
                },
                preloadNearbyImages: function () {
                    var e, t = d.st.gallery.preload, n = Math.min(t[0], d.items.length),
                        i = Math.min(t[1], d.items.length);
                    for (e = 1; e <= (d.direction ? i : n); e++)
                        d._preloadItem(d.index + e);
                    for (e = 1; e <= (d.direction ? n : i); e++)
                        d._preloadItem(d.index - e)
                },
                _preloadItem: function (e) {
                    if (e = P(e),
                        !d.items[e].preloaded) {
                        var t = d.items[e];
                        t.parsed || (t = d.parseEl(e)),
                            w("LazyLoad", t),
                        "image" === t.type && (t.img = c('<img class="mfp-img" />').on("load.mfploader", function () {
                            t.hasSize = !0
                        }).on("error.mfploader", function () {
                            t.hasSize = !0,
                                t.loadError = !0,
                                w("LazyLoadError", t)
                        }).attr("src", t.src)),
                            t.preloaded = !0
                    }
                }
            }
        });
        var M = "retina";
        c.magnificPopup.registerModule(M, {
            options: {
                replaceSrc: function (e) {
                    return e.src.replace(/\.\w+$/, function (e) {
                        return "@2x" + e
                    })
                },
                ratio: 1
            },
            proto: {
                initRetina: function () {
                    if (1 < window.devicePixelRatio) {
                        var n = d.st.retina
                            , i = n.ratio;
                        1 < (i = isNaN(i) ? i() : i) && (b("ImageHasSize." + M, function (e, t) {
                            t.img.css({
                                "max-width": t.img[0].naturalWidth / i,
                                width: "100%"
                            })
                        }),
                            b("ElementParse." + M, function (e, t) {
                                t.src = n.replaceSrc(t, i)
                            }))
                    }
                }
            }
        }),
            o()
    }),
    function (e, t) {
        "function" == typeof define && define.amd ? define("ev-emitter/ev-emitter", t) : "object" == typeof module && module.exports ? module.exports = t() : e.EvEmitter = t()
    }(this, function () {
        function e() {
        }

        var t = e.prototype;
        return t.on = function (e, t) {
            if (e && t) {
                var n = this._events = this._events || {}
                    , i = n[e] = n[e] || [];
                return -1 == i.indexOf(t) && i.push(t),
                    this
            }
        }
            ,
            t.once = function (e, t) {
                if (e && t) {
                    this.on(e, t);
                    var n = this._onceEvents = this._onceEvents || {};
                    return (n[e] = n[e] || [])[t] = !0,
                        this
                }
            }
            ,
            t.off = function (e, t) {
                var n = this._events && this._events[e];
                if (n && n.length) {
                    var i = n.indexOf(t);
                    return -1 != i && n.splice(i, 1),
                        this
                }
            }
            ,
            t.emitEvent = function (e, t) {
                var n = this._events && this._events[e];
                if (n && n.length) {
                    var i = 0
                        , r = n[i];
                    t = t || [];
                    for (var o = this._onceEvents && this._onceEvents[e]; r;) {
                        var s = o && o[r];
                        s && (this.off(e, r),
                            delete o[r]),
                            r.apply(this, t),
                            r = n[i += s ? 0 : 1]
                    }
                    return this
                }
            }
            ,
            e
    }),
    function (t, n) {
        "use strict";
        "function" == typeof define && define.amd ? define(["ev-emitter/ev-emitter"], function (e) {
            return n(t, e)
        }) : "object" == typeof module && module.exports ? module.exports = n(t, require("ev-emitter")) : t.imagesLoaded = n(t, t.EvEmitter)
    }(window, function (t, e) {
        var i = t.jQuery
            , r = t.console;

        function o(e, t) {
            for (var n in t)
                e[n] = t[n];
            return e
        }

        function s(e, t, n) {
            if (!(this instanceof s))
                return new s(e, t, n);
            "string" == typeof e && (e = document.querySelectorAll(e)),
                this.elements = function (e) {
                    var t = [];
                    if (Array.isArray(e))
                        t = e;
                    else if ("number" == typeof e.length)
                        for (var n = 0; n < e.length; n++)
                            t.push(e[n]);
                    else
                        t.push(e);
                    return t
                }(e),
                this.options = o({}, this.options),
                "function" == typeof t ? n = t : o(this.options, t),
            n && this.on("always", n),
                this.getImages(),
            i && (this.jqDeferred = new i.Deferred),
                setTimeout(function () {
                    this.check()
                }
                    .bind(this))
        }

        (s.prototype = Object.create(e.prototype)).options = {},
            s.prototype.getImages = function () {
                this.images = [],
                    this.elements.forEach(this.addElementImages, this)
            }
            ,
            s.prototype.addElementImages = function (e) {
                "IMG" == e.nodeName && this.addImage(e),
                !0 === this.options.background && this.addElementBackgroundImages(e);
                var t = e.nodeType;
                if (t && a[t]) {
                    for (var n = e.querySelectorAll("img"), i = 0; i < n.length; i++) {
                        var r = n[i];
                        this.addImage(r)
                    }
                    if ("string" == typeof this.options.background) {
                        var o = e.querySelectorAll(this.options.background);
                        for (i = 0; i < o.length; i++) {
                            var s = o[i];
                            this.addElementBackgroundImages(s)
                        }
                    }
                }
            }
        ;
        var a = {
            1: !0,
            9: !0,
            11: !0
        };

        function n(e) {
            this.img = e
        }

        function u(e, t) {
            this.url = e,
                this.element = t,
                this.img = new Image
        }

        return s.prototype.addElementBackgroundImages = function (e) {
            var t = getComputedStyle(e);
            if (t)
                for (var n = /url\((['"])?(.*?)\1\)/gi, i = n.exec(t.backgroundImage); null !== i;) {
                    var r = i && i[2];
                    r && this.addBackground(r, e),
                        i = n.exec(t.backgroundImage)
                }
        }
            ,
            s.prototype.addImage = function (e) {
                var t = new n(e);
                this.images.push(t)
            }
            ,
            s.prototype.addBackground = function (e, t) {
                var n = new u(e, t);
                this.images.push(n)
            }
            ,
            s.prototype.check = function () {
                var i = this;

                function t(e, t, n) {
                    setTimeout(function () {
                        i.progress(e, t, n)
                    })
                }

                this.progressedCount = 0,
                    this.hasAnyBroken = !1,
                    this.images.length ? this.images.forEach(function (e) {
                        e.once("progress", t),
                            e.check()
                    }) : this.complete()
            }
            ,
            s.prototype.progress = function (e, t, n) {
                this.progressedCount++,
                    this.hasAnyBroken = this.hasAnyBroken || !e.isLoaded,
                    this.emitEvent("progress", [this, e, t]),
                this.jqDeferred && this.jqDeferred.notify && this.jqDeferred.notify(this, e),
                this.progressedCount == this.images.length && this.complete(),
                this.options.debug && r && r.log("progress: " + n, e, t)
            }
            ,
            s.prototype.complete = function () {
                var e = this.hasAnyBroken ? "fail" : "done";
                if (this.isComplete = !0,
                    this.emitEvent(e, [this]),
                    this.emitEvent("always", [this]),
                    this.jqDeferred) {
                    var t = this.hasAnyBroken ? "reject" : "resolve";
                    this.jqDeferred[t](this)
                }
            }
            ,
            (n.prototype = Object.create(e.prototype)).check = function () {
                this.getIsImageComplete() ? this.confirm(0 !== this.img.naturalWidth, "naturalWidth") : (this.proxyImage = new Image,
                    this.proxyImage.addEventListener("load", this),
                    this.proxyImage.addEventListener("error", this),
                    this.img.addEventListener("load", this),
                    this.img.addEventListener("error", this),
                    this.proxyImage.src = this.img.src)
            }
            ,
            n.prototype.getIsImageComplete = function () {
                return this.img.complete && void 0 !== this.img.naturalWidth
            }
            ,
            n.prototype.confirm = function (e, t) {
                this.isLoaded = e,
                    this.emitEvent("progress", [this, this.img, t])
            }
            ,
            n.prototype.handleEvent = function (e) {
                var t = "on" + e.type;
                this[t] && this[t](e)
            }
            ,
            n.prototype.onload = function () {
                this.confirm(!0, "onload"),
                    this.unbindEvents()
            }
            ,
            n.prototype.onerror = function () {
                this.confirm(!1, "onerror"),
                    this.unbindEvents()
            }
            ,
            n.prototype.unbindEvents = function () {
                this.proxyImage.removeEventListener("load", this),
                    this.proxyImage.removeEventListener("error", this),
                    this.img.removeEventListener("load", this),
                    this.img.removeEventListener("error", this)
            }
            ,
            (u.prototype = Object.create(n.prototype)).check = function () {
                this.img.addEventListener("load", this),
                    this.img.addEventListener("error", this),
                    this.img.src = this.url,
                this.getIsImageComplete() && (this.confirm(0 !== this.img.naturalWidth, "naturalWidth"),
                    this.unbindEvents())
            }
            ,
            u.prototype.unbindEvents = function () {
                this.img.removeEventListener("load", this),
                    this.img.removeEventListener("error", this)
            }
            ,
            u.prototype.confirm = function (e, t) {
                this.isLoaded = e,
                    this.emitEvent("progress", [this, this.element, t])
            }
            ,
            s.makeJQueryPlugin = function (e) {
                (e = e || t.jQuery) && ((i = e).fn.imagesLoaded = function (e, t) {
                        return new s(this, e, t).jqDeferred.promise(i(this))
                    }
                )
            }
            ,
            s.makeJQueryPlugin(),
            s
    }),
    function (t, n) {
        "use strict";
        "function" == typeof define && define.amd ? define("jquery-bridget/jquery-bridget", ["jquery"], function (e) {
            n(t, e)
        }) : "object" == typeof module && module.exports ? module.exports = n(t, require("jquery")) : t.jQueryBridget = n(t, t.jQuery)
    }(window, function (e, t) {
        "use strict";
        var d = Array.prototype.slice
            , n = e.console
            , h = void 0 === n ? function () {
            }
            : function (e) {
                n.error(e)
            }
        ;

        function i(l, r, c) {
            (c = c || t || e.jQuery) && (r.prototype.option || (r.prototype.option = function (e) {
                    c.isPlainObject(e) && (this.options = c.extend(!0, this.options, e))
                }
            ),
                c.fn[l] = function (e) {
                    if ("string" != typeof e)
                        return i = e,
                            this.each(function (e, t) {
                                var n = c.data(t, l);
                                n ? (n.option(i),
                                    n._init()) : (n = new r(t, i),
                                    c.data(t, l, n))
                            }),
                            this;
                    var t, o, s, a, u, i, n = d.call(arguments, 1);
                    return s = n,
                        u = "$()." + l + '("' + (o = e) + '")',
                        (t = this).each(function (e, t) {
                            var n = c.data(t, l);
                            if (n) {
                                var i = n[o];
                                if (i && "_" != o.charAt(0)) {
                                    var r = i.apply(n, s);
                                    a = void 0 === a ? r : a
                                } else
                                    h(u + " is not a valid method")
                            } else
                                h(l + " not initialized. Cannot call methods, i.e. " + u)
                        }),
                        void 0 !== a ? a : t
                }
                ,
                o(c))
        }

        function o(e) {
            !e || e && e.bridget || (e.bridget = i)
        }

        return o(t || e.jQuery),
            i
    }),
    function (e, t) {
        "function" == typeof define && define.amd ? define("ev-emitter/ev-emitter", t) : "object" == typeof module && module.exports ? module.exports = t() : e.EvEmitter = t()
    }(this, function () {
        function e() {
        }

        var t = e.prototype;
        return t.on = function (e, t) {
            if (e && t) {
                var n = this._events = this._events || {}
                    , i = n[e] = n[e] || [];
                return -1 == i.indexOf(t) && i.push(t),
                    this
            }
        }
            ,
            t.once = function (e, t) {
                if (e && t) {
                    this.on(e, t);
                    var n = this._onceEvents = this._onceEvents || {};
                    return (n[e] = n[e] || [])[t] = !0,
                        this
                }
            }
            ,
            t.off = function (e, t) {
                var n = this._events && this._events[e];
                if (n && n.length) {
                    var i = n.indexOf(t);
                    return -1 != i && n.splice(i, 1),
                        this
                }
            }
            ,
            t.emitEvent = function (e, t) {
                var n = this._events && this._events[e];
                if (n && n.length) {
                    var i = 0
                        , r = n[i];
                    t = t || [];
                    for (var o = this._onceEvents && this._onceEvents[e]; r;) {
                        var s = o && o[r];
                        s && (this.off(e, r),
                            delete o[r]),
                            r.apply(this, t),
                            r = n[i += s ? 0 : 1]
                    }
                    return this
                }
            }
            ,
            e
    }),
    function (e, t) {
        "use strict";
        "function" == typeof define && define.amd ? define("get-size/get-size", [], function () {
            return t()
        }) : "object" == typeof module && module.exports ? module.exports = t() : e.getSize = t()
    }(window, function () {
        "use strict";

        function v(e) {
            var t = parseFloat(e);
            return -1 == e.indexOf("%") && !isNaN(t) && t
        }

        var n = "undefined" == typeof console ? function () {
            }
            : function (e) {
                console.error(e)
            }
            ,
            y = ["paddingLeft", "paddingRight", "paddingTop", "paddingBottom", "marginLeft", "marginRight", "marginTop", "marginBottom", "borderLeftWidth", "borderRightWidth", "borderTopWidth", "borderBottomWidth"]
            , b = y.length;

        function x(e) {
            var t = getComputedStyle(e);
            return t || n("Style returned " + t + ". Are you running this code in a hidden iframe on Firefox? See http://bit.ly/getsizebug1"),
                t
        }

        var w, C = !1;

        function T(e) {
            if (function () {
                if (!C) {
                    C = !0;
                    var e = document.createElement("div");
                    e.style.width = "200px",
                        e.style.padding = "1px 2px 3px 4px",
                        e.style.borderStyle = "solid",
                        e.style.borderWidth = "1px 2px 3px 4px",
                        e.style.boxSizing = "border-box";
                    var t = document.body || document.documentElement;
                    t.appendChild(e);
                    var n = x(e);
                    T.isBoxSizeOuter = w = 200 == v(n.width),
                        t.removeChild(e)
                }
            }(),
            "string" == typeof e && (e = document.querySelector(e)),
            e && "object" == typeof e && e.nodeType) {
                var t = x(e);
                if ("none" == t.display)
                    return function () {
                        for (var e = {
                            width: 0,
                            height: 0,
                            innerWidth: 0,
                            innerHeight: 0,
                            outerWidth: 0,
                            outerHeight: 0
                        }, t = 0; t < b; t++)
                            e[y[t]] = 0;
                        return e
                    }();
                var n = {};
                n.width = e.offsetWidth,
                    n.height = e.offsetHeight;
                for (var i = n.isBorderBox = "border-box" == t.boxSizing, r = 0; r < b; r++) {
                    var o = y[r]
                        , s = t[o]
                        , a = parseFloat(s);
                    n[o] = isNaN(a) ? 0 : a
                }
                var u = n.paddingLeft + n.paddingRight
                    , l = n.paddingTop + n.paddingBottom
                    , c = n.marginLeft + n.marginRight
                    , d = n.marginTop + n.marginBottom
                    , h = n.borderLeftWidth + n.borderRightWidth
                    , f = n.borderTopWidth + n.borderBottomWidth
                    , p = i && w
                    , m = v(t.width);
                !1 !== m && (n.width = m + (p ? 0 : u + h));
                var g = v(t.height);
                return !1 !== g && (n.height = g + (p ? 0 : l + f)),
                    n.innerWidth = n.width - (u + h),
                    n.innerHeight = n.height - (l + f),
                    n.outerWidth = n.width + c,
                    n.outerHeight = n.height + d,
                    n
            }
        }

        return T
    }),
    function (e, t) {
        "use strict";
        "function" == typeof define && define.amd ? define("matches-selector/matches-selector", t) : "object" == typeof module && module.exports ? module.exports = t() : e.matchesSelector = t()
    }(window, function () {
        "use strict";
        var n = function () {
            var e = Element.prototype;
            if (e.matches)
                return "matches";
            if (e.matchesSelector)
                return "matchesSelector";
            for (var t = ["webkit", "moz", "ms", "o"], n = 0; n < t.length; n++) {
                var i = t[n] + "MatchesSelector";
                if (e[i])
                    return i
            }
        }();
        return function (e, t) {
            return e[n](t)
        }
    }),
    function (t, n) {
        "use strict";
        "function" == typeof define && define.amd ? define("fizzy-ui-utils/utils", ["matches-selector/matches-selector"], function (e) {
            return n(t, e)
        }) : "object" == typeof module && module.exports ? module.exports = n(t, require("desandro-matches-selector")) : t.fizzyUIUtils = n(t, t.matchesSelector)
    }(window, function (l, o) {
        var c = {
            extend: function (e, t) {
                for (var n in t)
                    e[n] = t[n];
                return e
            },
            modulo: function (e, t) {
                return (e % t + t) % t
            },
            makeArray: function (e) {
                var t = [];
                if (Array.isArray(e))
                    t = e;
                else if (e && "number" == typeof e.length)
                    for (var n = 0; n < e.length; n++)
                        t.push(e[n]);
                else
                    t.push(e);
                return t
            },
            removeFrom: function (e, t) {
                var n = e.indexOf(t);
                -1 != n && e.splice(n, 1)
            },
            getParent: function (e, t) {
                for (; e != document.body;)
                    if (e = e.parentNode,
                        o(e, t))
                        return e
            },
            getQueryElement: function (e) {
                return "string" == typeof e ? document.querySelector(e) : e
            },
            handleEvent: function (e) {
                var t = "on" + e.type;
                this[t] && this[t](e)
            },
            filterFindElements: function (e, i) {
                e = c.makeArray(e);
                var r = [];
                return e.forEach(function (e) {
                    if (e instanceof HTMLElement)
                        if (i) {
                            o(e, i) && r.push(e);
                            for (var t = e.querySelectorAll(i), n = 0; n < t.length; n++)
                                r.push(t[n])
                        } else
                            r.push(e)
                }),
                    r
            },
            debounceMethod: function (e, t, i) {
                var r = e.prototype[t]
                    , o = t + "Timeout";
                e.prototype[t] = function () {
                    var e = this[o];
                    e && clearTimeout(e);
                    var t = arguments
                        , n = this;
                    this[o] = setTimeout(function () {
                        r.apply(n, t),
                            delete n[o]
                    }, i || 100)
                }
            },
            docReady: function (e) {
                "complete" == document.readyState ? e() : document.addEventListener("DOMContentLoaded", e)
            },
            toDashed: function (e) {
                return e.replace(/(.)([A-Z])/g, function (e, t, n) {
                    return t + "-" + n
                }).toLowerCase()
            }
        }
            , d = l.console;
        return c.htmlInit = function (a, u) {
            c.docReady(function () {
                var e = c.toDashed(u)
                    , r = "data-" + e
                    , t = document.querySelectorAll("[" + r + "]")
                    , n = document.querySelectorAll(".js-" + e)
                    , i = c.makeArray(t).concat(c.makeArray(n))
                    , o = r + "-options"
                    , s = l.jQuery;
                i.forEach(function (t) {
                    var e, n = t.getAttribute(r) || t.getAttribute(o);
                    try {
                        e = n && JSON.parse(n)
                    } catch (e) {
                        return void (d && d.error("Error parsing " + r + " on " + t.className + ": " + e))
                    }
                    var i = new a(t, e);
                    s && s.data(t, u, i)
                })
            })
        }
            ,
            c
    }),
    function (n, i) {
        "function" == typeof define && define.amd ? define("outlayer/item", ["ev-emitter/ev-emitter", "get-size/get-size"], function (e, t) {
            return i(n, e, t)
        }) : "object" == typeof module && module.exports ? module.exports = i(n, require("ev-emitter"), require("get-size")) : (n.Outlayer = {},
            n.Outlayer.Item = i(n, n.EvEmitter, n.getSize))
    }(window, function (e, t, n) {
        "use strict";
        var i = document.documentElement.style
            , r = "string" == typeof i.transition ? "transition" : "WebkitTransition"
            , o = "string" == typeof i.transform ? "transform" : "WebkitTransform"
            , s = {
            WebkitTransition: "webkitTransitionEnd",
            transition: "transitionend"
        }[r]
            , a = [o, r, r + "Duration", r + "Property"];

        function u(e, t) {
            e && (this.element = e,
                this.layout = t,
                this.position = {
                    x: 0,
                    y: 0
                },
                this._create())
        }

        var l = u.prototype = Object.create(t.prototype);
        l.constructor = u,
            l._create = function () {
                this._transn = {
                    ingProperties: {},
                    clean: {},
                    onEnd: {}
                },
                    this.css({
                        position: "absolute"
                    })
            }
            ,
            l.handleEvent = function (e) {
                var t = "on" + e.type;
                this[t] && this[t](e)
            }
            ,
            l.getSize = function () {
                this.size = n(this.element)
            }
            ,
            l.css = function (e) {
                var t = this.element.style;
                for (var n in e) {
                    t[a[n] || n] = e[n]
                }
            }
            ,
            l.getPosition = function () {
                var e = getComputedStyle(this.element)
                    , t = this.layout._getOption("originLeft")
                    , n = this.layout._getOption("originTop")
                    , i = e[t ? "left" : "right"]
                    , r = e[n ? "top" : "bottom"]
                    , o = this.layout.size
                    , s = -1 != i.indexOf("%") ? parseFloat(i) / 100 * o.width : parseInt(i, 10)
                    , a = -1 != r.indexOf("%") ? parseFloat(r) / 100 * o.height : parseInt(r, 10);
                s = isNaN(s) ? 0 : s,
                    a = isNaN(a) ? 0 : a,
                    s -= t ? o.paddingLeft : o.paddingRight,
                    a -= n ? o.paddingTop : o.paddingBottom,
                    this.position.x = s,
                    this.position.y = a
            }
            ,
            l.layoutPosition = function () {
                var e = this.layout.size
                    , t = {}
                    , n = this.layout._getOption("originLeft")
                    , i = this.layout._getOption("originTop")
                    , r = n ? "paddingLeft" : "paddingRight"
                    , o = n ? "left" : "right"
                    , s = n ? "right" : "left"
                    , a = this.position.x + e[r];
                t[o] = this.getXValue(a),
                    t[s] = "";
                var u = i ? "paddingTop" : "paddingBottom"
                    , l = i ? "top" : "bottom"
                    , c = i ? "bottom" : "top"
                    , d = this.position.y + e[u];
                t[l] = this.getYValue(d),
                    t[c] = "",
                    this.css(t),
                    this.emitEvent("layout", [this])
            }
            ,
            l.getXValue = function (e) {
                var t = this.layout._getOption("horizontal");
                return this.layout.options.percentPosition && !t ? e / this.layout.size.width * 100 + "%" : e + "px"
            }
            ,
            l.getYValue = function (e) {
                var t = this.layout._getOption("horizontal");
                return this.layout.options.percentPosition && t ? e / this.layout.size.height * 100 + "%" : e + "px"
            }
            ,
            l._transitionTo = function (e, t) {
                this.getPosition();
                var n = this.position.x
                    , i = this.position.y
                    , r = parseInt(e, 10)
                    , o = parseInt(t, 10)
                    , s = r === this.position.x && o === this.position.y;
                if (this.setPosition(e, t),
                !s || this.isTransitioning) {
                    var a = e - n
                        , u = t - i
                        , l = {};
                    l.transform = this.getTranslate(a, u),
                        this.transition({
                            to: l,
                            onTransitionEnd: {
                                transform: this.layoutPosition
                            },
                            isCleaning: !0
                        })
                } else
                    this.layoutPosition()
            }
            ,
            l.getTranslate = function (e, t) {
                return "translate3d(" + (e = this.layout._getOption("originLeft") ? e : -e) + "px, " + (t = this.layout._getOption("originTop") ? t : -t) + "px, 0)"
            }
            ,
            l.goTo = function (e, t) {
                this.setPosition(e, t),
                    this.layoutPosition()
            }
            ,
            l.moveTo = l._transitionTo,
            l.setPosition = function (e, t) {
                this.position.x = parseInt(e, 10),
                    this.position.y = parseInt(t, 10)
            }
            ,
            l._nonTransition = function (e) {
                for (var t in this.css(e.to),
                e.isCleaning && this._removeStyles(e.to),
                    e.onTransitionEnd)
                    e.onTransitionEnd[t].call(this)
            }
            ,
            l._transition = function (e) {
                if (parseFloat(this.layout.options.transitionDuration)) {
                    var t = this._transn;
                    for (var n in e.onTransitionEnd)
                        t.onEnd[n] = e.onTransitionEnd[n];
                    for (n in e.to)
                        t.ingProperties[n] = !0,
                        e.isCleaning && (t.clean[n] = !0);
                    if (e.from) {
                        this.css(e.from);
                        this.element.offsetHeight;
                        null
                    }
                    this.enableTransition(e.to),
                        this.css(e.to),
                        this.isTransitioning = !0
                } else
                    this._nonTransition(e)
            }
        ;
        var c = "opacity," + (a.transform || "transform").replace(/([A-Z])/g, function (e) {
            return "-" + e.toLowerCase()
        });
        l.enableTransition = function () {
            this.isTransitioning || (this.css({
                transitionProperty: c,
                transitionDuration: this.layout.options.transitionDuration
            }),
                this.element.addEventListener(s, this, !1))
        }
            ,
            l.transition = u.prototype[r ? "_transition" : "_nonTransition"],
            l.onwebkitTransitionEnd = function (e) {
                this.ontransitionend(e)
            }
            ,
            l.onotransitionend = function (e) {
                this.ontransitionend(e)
            }
        ;
        var d = {
            "-webkit-transform": "transform"
        };
        l.ontransitionend = function (e) {
            if (e.target === this.element) {
                var t = this._transn
                    , n = d[e.propertyName] || e.propertyName;
                if (delete t.ingProperties[n],
                function (e) {
                    for (var t in e)
                        return !1;
                    return !0
                }(t.ingProperties) && this.disableTransition(),
                n in t.clean && (this.element.style[e.propertyName] = "",
                    delete t.clean[n]),
                n in t.onEnd)
                    t.onEnd[n].call(this),
                        delete t.onEnd[n];
                this.emitEvent("transitionEnd", [this])
            }
        }
            ,
            l.disableTransition = function () {
                this.removeTransitionStyles(),
                    this.element.removeEventListener(s, this, !1),
                    this.isTransitioning = !1
            }
            ,
            l._removeStyles = function (e) {
                var t = {};
                for (var n in e)
                    t[n] = "";
                this.css(t)
            }
        ;
        var h = {
            transitionProperty: "",
            transitionDuration: ""
        };
        return l.removeTransitionStyles = function () {
            this.css(h)
        }
            ,
            l.removeElem = function () {
                this.element.parentNode.removeChild(this.element),
                    this.css({
                        display: ""
                    }),
                    this.emitEvent("remove", [this])
            }
            ,
            l.remove = function () {
                r && parseFloat(this.layout.options.transitionDuration) ? (this.once("transitionEnd", function () {
                    this.removeElem()
                }),
                    this.hide()) : this.removeElem()
            }
            ,
            l.reveal = function () {
                delete this.isHidden,
                    this.css({
                        display: ""
                    });
                var e = this.layout.options
                    , t = {};
                t[this.getHideRevealTransitionEndProperty("visibleStyle")] = this.onRevealTransitionEnd,
                    this.transition({
                        from: e.hiddenStyle,
                        to: e.visibleStyle,
                        isCleaning: !0,
                        onTransitionEnd: t
                    })
            }
            ,
            l.onRevealTransitionEnd = function () {
                this.isHidden || this.emitEvent("reveal")
            }
            ,
            l.getHideRevealTransitionEndProperty = function (e) {
                var t = this.layout.options[e];
                if (t.opacity)
                    return "opacity";
                for (var n in t)
                    return n
            }
            ,
            l.hide = function () {
                this.isHidden = !0,
                    this.css({
                        display: ""
                    });
                var e = this.layout.options
                    , t = {};
                t[this.getHideRevealTransitionEndProperty("hiddenStyle")] = this.onHideTransitionEnd,
                    this.transition({
                        from: e.visibleStyle,
                        to: e.hiddenStyle,
                        isCleaning: !0,
                        onTransitionEnd: t
                    })
            }
            ,
            l.onHideTransitionEnd = function () {
                this.isHidden && (this.css({
                    display: "none"
                }),
                    this.emitEvent("hide"))
            }
            ,
            l.destroy = function () {
                this.css({
                    position: "",
                    left: "",
                    right: "",
                    top: "",
                    bottom: "",
                    transition: "",
                    transform: ""
                })
            }
            ,
            u
    }),
    function (r, o) {
        "use strict";
        "function" == typeof define && define.amd ? define("outlayer/outlayer", ["ev-emitter/ev-emitter", "get-size/get-size", "fizzy-ui-utils/utils", "./item"], function (e, t, n, i) {
            return o(r, e, t, n, i)
        }) : "object" == typeof module && module.exports ? module.exports = o(r, require("ev-emitter"), require("get-size"), require("fizzy-ui-utils"), require("./item")) : r.Outlayer = o(r, r.EvEmitter, r.getSize, r.fizzyUIUtils, r.Outlayer.Item)
    }(window, function (e, t, r, o, i) {
        "use strict";
        var s = e.console
            , a = e.jQuery
            , n = function () {
        }
            , u = 0
            , l = {};

        function c(e, t) {
            var n = o.getQueryElement(e);
            if (n) {
                this.element = n,
                a && (this.$element = a(this.element)),
                    this.options = o.extend({}, this.constructor.defaults),
                    this.option(t);
                var i = ++u;
                this.element.outlayerGUID = i,
                    (l[i] = this)._create(),
                this._getOption("initLayout") && this.layout()
            } else
                s && s.error("Bad element for " + this.constructor.namespace + ": " + (n || e))
        }

        c.namespace = "outlayer",
            c.Item = i,
            c.defaults = {
                containerStyle: {
                    position: "relative"
                },
                initLayout: !0,
                originLeft: !0,
                originTop: !0,
                resize: !0,
                resizeContainer: !0,
                transitionDuration: "0.4s",
                hiddenStyle: {
                    opacity: 0,
                    transform: "scale(0.001)"
                },
                visibleStyle: {
                    opacity: 1,
                    transform: "scale(1)"
                }
            };
        var d = c.prototype;

        function h(e) {
            function t() {
                e.apply(this, arguments)
            }

            return (t.prototype = Object.create(e.prototype)).constructor = t
        }

        return o.extend(d, t.prototype),
            d.option = function (e) {
                o.extend(this.options, e)
            }
            ,
            d._getOption = function (e) {
                var t = this.constructor.compatOptions[e];
                return t && void 0 !== this.options[t] ? this.options[t] : this.options[e]
            }
            ,
            c.compatOptions = {
                initLayout: "isInitLayout",
                horizontal: "isHorizontal",
                layoutInstant: "isLayoutInstant",
                originLeft: "isOriginLeft",
                originTop: "isOriginTop",
                resize: "isResizeBound",
                resizeContainer: "isResizingContainer"
            },
            d._create = function () {
                this.reloadItems(),
                    this.stamps = [],
                    this.stamp(this.options.stamp),
                    o.extend(this.element.style, this.options.containerStyle),
                this._getOption("resize") && this.bindResize()
            }
            ,
            d.reloadItems = function () {
                this.items = this._itemize(this.element.children)
            }
            ,
            d._itemize = function (e) {
                for (var t = this._filterFindItemElements(e), n = this.constructor.Item, i = [], r = 0; r < t.length; r++) {
                    var o = new n(t[r], this);
                    i.push(o)
                }
                return i
            }
            ,
            d._filterFindItemElements = function (e) {
                return o.filterFindElements(e, this.options.itemSelector)
            }
            ,
            d.getItemElements = function () {
                return this.items.map(function (e) {
                    return e.element
                })
            }
            ,
            d.layout = function () {
                this._resetLayout(),
                    this._manageStamps();
                var e = this._getOption("layoutInstant")
                    , t = void 0 !== e ? e : !this._isLayoutInited;
                this.layoutItems(this.items, t),
                    this._isLayoutInited = !0
            }
            ,
            d._init = d.layout,
            d._resetLayout = function () {
                this.getSize()
            }
            ,
            d.getSize = function () {
                this.size = r(this.element)
            }
            ,
            d._getMeasurement = function (e, t) {
                var n, i = this.options[e];
                this[e] = i ? ("string" == typeof i ? n = this.element.querySelector(i) : i instanceof HTMLElement && (n = i),
                    n ? r(n)[t] : i) : 0
            }
            ,
            d.layoutItems = function (e, t) {
                e = this._getItemsForLayout(e),
                    this._layoutItems(e, t),
                    this._postLayout()
            }
            ,
            d._getItemsForLayout = function (e) {
                return e.filter(function (e) {
                    return !e.isIgnored
                })
            }
            ,
            d._layoutItems = function (e, n) {
                if (this._emitCompleteOnItems("layout", e),
                e && e.length) {
                    var i = [];
                    e.forEach(function (e) {
                        var t = this._getItemLayoutPosition(e);
                        t.item = e,
                            t.isInstant = n || e.isLayoutInstant,
                            i.push(t)
                    }, this),
                        this._processLayoutQueue(i)
                }
            }
            ,
            d._getItemLayoutPosition = function () {
                return {
                    x: 0,
                    y: 0
                }
            }
            ,
            d._processLayoutQueue = function (e) {
                e.forEach(function (e) {
                    this._positionItem(e.item, e.x, e.y, e.isInstant)
                }, this)
            }
            ,
            d._positionItem = function (e, t, n, i) {
                i ? e.goTo(t, n) : e.moveTo(t, n)
            }
            ,
            d._postLayout = function () {
                this.resizeContainer()
            }
            ,
            d.resizeContainer = function () {
                if (this._getOption("resizeContainer")) {
                    var e = this._getContainerSize();
                    e && (this._setContainerMeasure(e.width, !0),
                        this._setContainerMeasure(e.height, !1))
                }
            }
            ,
            d._getContainerSize = n,
            d._setContainerMeasure = function (e, t) {
                if (void 0 !== e) {
                    var n = this.size;
                    n.isBorderBox && (e += t ? n.paddingLeft + n.paddingRight + n.borderLeftWidth + n.borderRightWidth : n.paddingBottom + n.paddingTop + n.borderTopWidth + n.borderBottomWidth),
                        e = Math.max(e, 0),
                        this.element.style[t ? "width" : "height"] = e + "px"
                }
            }
            ,
            d._emitCompleteOnItems = function (t, e) {
                var n = this;

                function i() {
                    n.dispatchEvent(t + "Complete", null, [e])
                }

                var r = e.length;
                if (e && r) {
                    var o = 0;
                    e.forEach(function (e) {
                        e.once(t, s)
                    })
                } else
                    i();

                function s() {
                    ++o == r && i()
                }
            }
            ,
            d.dispatchEvent = function (e, t, n) {
                var i = t ? [t].concat(n) : n;
                if (this.emitEvent(e, i),
                    a)
                    if (this.$element = this.$element || a(this.element),
                        t) {
                        var r = a.Event(t);
                        r.type = e,
                            this.$element.trigger(r, n)
                    } else
                        this.$element.trigger(e, n)
            }
            ,
            d.ignore = function (e) {
                var t = this.getItem(e);
                t && (t.isIgnored = !0)
            }
            ,
            d.unignore = function (e) {
                var t = this.getItem(e);
                t && delete t.isIgnored
            }
            ,
            d.stamp = function (e) {
                (e = this._find(e)) && (this.stamps = this.stamps.concat(e),
                    e.forEach(this.ignore, this))
            }
            ,
            d.unstamp = function (e) {
                (e = this._find(e)) && e.forEach(function (e) {
                    o.removeFrom(this.stamps, e),
                        this.unignore(e)
                }, this)
            }
            ,
            d._find = function (e) {
                if (e)
                    return "string" == typeof e && (e = this.element.querySelectorAll(e)),
                        e = o.makeArray(e)
            }
            ,
            d._manageStamps = function () {
                this.stamps && this.stamps.length && (this._getBoundingRect(),
                    this.stamps.forEach(this._manageStamp, this))
            }
            ,
            d._getBoundingRect = function () {
                var e = this.element.getBoundingClientRect()
                    , t = this.size;
                this._boundingRect = {
                    left: e.left + t.paddingLeft + t.borderLeftWidth,
                    top: e.top + t.paddingTop + t.borderTopWidth,
                    right: e.right - (t.paddingRight + t.borderRightWidth),
                    bottom: e.bottom - (t.paddingBottom + t.borderBottomWidth)
                }
            }
            ,
            d._manageStamp = n,
            d._getElementOffset = function (e) {
                var t = e.getBoundingClientRect()
                    , n = this._boundingRect
                    , i = r(e);
                return {
                    left: t.left - n.left - i.marginLeft,
                    top: t.top - n.top - i.marginTop,
                    right: n.right - t.right - i.marginRight,
                    bottom: n.bottom - t.bottom - i.marginBottom
                }
            }
            ,
            d.handleEvent = o.handleEvent,
            d.bindResize = function () {
                e.addEventListener("resize", this),
                    this.isResizeBound = !0
            }
            ,
            d.unbindResize = function () {
                e.removeEventListener("resize", this),
                    this.isResizeBound = !1
            }
            ,
            d.onresize = function () {
                this.resize()
            }
            ,
            o.debounceMethod(c, "onresize", 100),
            d.resize = function () {
                this.isResizeBound && this.needsResizeLayout() && this.layout()
            }
            ,
            d.needsResizeLayout = function () {
                var e = r(this.element);
                return this.size && e && e.innerWidth !== this.size.innerWidth
            }
            ,
            d.addItems = function (e) {
                var t = this._itemize(e);
                return t.length && (this.items = this.items.concat(t)),
                    t
            }
            ,
            d.appended = function (e) {
                var t = this.addItems(e);
                t.length && (this.layoutItems(t, !0),
                    this.reveal(t))
            }
            ,
            d.prepended = function (e) {
                var t = this._itemize(e);
                if (t.length) {
                    var n = this.items.slice(0);
                    this.items = t.concat(n),
                        this._resetLayout(),
                        this._manageStamps(),
                        this.layoutItems(t, !0),
                        this.reveal(t),
                        this.layoutItems(n)
                }
            }
            ,
            d.reveal = function (e) {
                this._emitCompleteOnItems("reveal", e),
                e && e.length && e.forEach(function (e) {
                    e.reveal()
                })
            }
            ,
            d.hide = function (e) {
                this._emitCompleteOnItems("hide", e),
                e && e.length && e.forEach(function (e) {
                    e.hide()
                })
            }
            ,
            d.revealItemElements = function (e) {
                var t = this.getItems(e);
                this.reveal(t)
            }
            ,
            d.hideItemElements = function (e) {
                var t = this.getItems(e);
                this.hide(t)
            }
            ,
            d.getItem = function (e) {
                for (var t = 0; t < this.items.length; t++) {
                    var n = this.items[t];
                    if (n.element == e)
                        return n
                }
            }
            ,
            d.getItems = function (e) {
                e = o.makeArray(e);
                var n = [];
                return e.forEach(function (e) {
                    var t = this.getItem(e);
                    t && n.push(t)
                }, this),
                    n
            }
            ,
            d.remove = function (e) {
                var t = this.getItems(e);
                this._emitCompleteOnItems("remove", t),
                t && t.length && t.forEach(function (e) {
                    e.remove(),
                        o.removeFrom(this.items, e)
                }, this)
            }
            ,
            d.destroy = function () {
                var e = this.element.style;
                e.height = "",
                    e.position = "",
                    e.width = "",
                    this.items.forEach(function (e) {
                        e.destroy()
                    }),
                    this.unbindResize();
                var t = this.element.outlayerGUID;
                delete l[t],
                    delete this.element.outlayerGUID,
                a && a.removeData(this.element, this.constructor.namespace)
            }
            ,
            c.data = function (e) {
                var t = (e = o.getQueryElement(e)) && e.outlayerGUID;
                return t && l[t]
            }
            ,
            c.create = function (e, t) {
                var n = h(c);
                return n.defaults = o.extend({}, c.defaults),
                    o.extend(n.defaults, t),
                    n.compatOptions = o.extend({}, c.compatOptions),
                    n.namespace = e,
                    n.data = c.data,
                    n.Item = h(i),
                    o.htmlInit(n, e),
                a && a.bridget && a.bridget(e, n),
                    n
            }
            ,
            c.Item = i,
            c
    }),
    function (e, t) {
        "function" == typeof define && define.amd ? define(["outlayer/outlayer", "get-size/get-size"], t) : "object" == typeof module && module.exports ? module.exports = t(require("outlayer"), require("get-size")) : e.Masonry = t(e.Outlayer, e.getSize)
    }(window, function (e, l) {
        var t = e.create("masonry");
        return t.compatOptions.fitWidth = "isFitWidth",
            t.prototype._resetLayout = function () {
                this.getSize(),
                    this._getMeasurement("columnWidth", "outerWidth"),
                    this._getMeasurement("gutter", "outerWidth"),
                    this.measureColumns(),
                    this.colYs = [];
                for (var e = 0; e < this.cols; e++)
                    this.colYs.push(0);
                this.maxY = 0
            }
            ,
            t.prototype.measureColumns = function () {
                if (this.getContainerWidth(),
                    !this.columnWidth) {
                    var e = this.items[0]
                        , t = e && e.element;
                    this.columnWidth = t && l(t).outerWidth || this.containerWidth
                }
                var n = this.columnWidth += this.gutter
                    , i = this.containerWidth + this.gutter
                    , r = i / n
                    , o = n - i % n;
                r = Math[o && o < 1 ? "round" : "floor"](r),
                    this.cols = Math.max(r, 1)
            }
            ,
            t.prototype.getContainerWidth = function () {
                var e = this._getOption("fitWidth") ? this.element.parentNode : this.element
                    , t = l(e);
                this.containerWidth = t && t.innerWidth
            }
            ,
            t.prototype._getItemLayoutPosition = function (e) {
                e.getSize();
                var t = e.size.outerWidth % this.columnWidth
                    , n = Math[t && t < 1 ? "round" : "ceil"](e.size.outerWidth / this.columnWidth);
                n = Math.min(n, this.cols);
                for (var i = this._getColGroup(n), r = Math.min.apply(Math, i), o = i.indexOf(r), s = {
                    x: this.columnWidth * o,
                    y: r
                }, a = r + e.size.outerHeight, u = this.cols + 1 - i.length, l = 0; l < u; l++)
                    this.colYs[o + l] = a;
                return s
            }
            ,
            t.prototype._getColGroup = function (e) {
                if (e < 2)
                    return this.colYs;
                for (var t = [], n = this.cols + 1 - e, i = 0; i < n; i++) {
                    var r = this.colYs.slice(i, i + e);
                    t[i] = Math.max.apply(Math, r)
                }
                return t
            }
            ,
            t.prototype._manageStamp = function (e) {
                var t = l(e)
                    , n = this._getElementOffset(e)
                    , i = this._getOption("originLeft") ? n.left : n.right
                    , r = i + t.outerWidth
                    , o = Math.floor(i / this.columnWidth);
                o = Math.max(0, o);
                var s = Math.floor(r / this.columnWidth);
                s -= r % this.columnWidth ? 0 : 1,
                    s = Math.min(this.cols - 1, s);
                for (var a = (this._getOption("originTop") ? n.top : n.bottom) + t.outerHeight, u = o; u <= s; u++)
                    this.colYs[u] = Math.max(a, this.colYs[u])
            }
            ,
            t.prototype._getContainerSize = function () {
                this.maxY = Math.max.apply(Math, this.colYs);
                var e = {
                    height: this.maxY
                };
                return this._getOption("fitWidth") && (e.width = this._getContainerFitWidth()),
                    e
            }
            ,
            t.prototype._getContainerFitWidth = function () {
                for (var e = 0, t = this.cols; --t && 0 === this.colYs[t];)
                    e++;
                return (this.cols - e) * this.columnWidth - this.gutter
            }
            ,
            t.prototype.needsResizeLayout = function () {
                var e = this.containerWidth;
                return this.getContainerWidth(),
                e != this.containerWidth
            }
            ,
            t
    }),
    function (l) {
        "use strict";
        l.fn.multipleFilterMasonry = function (i) {
            var r = []
                , o = [];
            "list" === i.selectorType && l(i.filtersGroupSelector).children().each(function () {
                o.push(l(this).data("filter"))
            });
            var s = function (e) {
                var i = [];
                return l(r).each(function (n) {
                    l(e).each(function (e, t) {
                        r[n].is(t) && -1 === l.inArray(r[n], i) && i.push(r[n])
                    })
                }),
                    i
            }
                , a = function (e, t) {
                e.empty(),
                    l(t).each(function () {
                        l(e).append(l(this))
                    }),
                    e.masonry("reloadItems"),
                    e.masonry()
            }
                , u = function (n) {
                var e, t;
                l(i.filtersGroupSelector).children().each(function () {
                    l(this).click(function () {
                        l(i.filtersGroupSelector).children().removeClass("selected"),
                            window.location.hash = l(this).data("filter");
                        var e = [];
                        e.push("." + l(this).data("filter")),
                            l(this).addClass("selected");
                        var t = r;
                        0 < e.length && (t = s(e)),
                            a(n, t)
                    })
                }),
                    e = n,
                    t = window.location.hash.replace("#", ""),
                -1 !== l.inArray(t, o) && a(e, l("." + t)),
                    l(i.filtersGroupSelector).children().removeClass("selected"),
                    l(".filters li[data-filter=" + window.location.hash.replace("#", "") + "]").addClass("selected")
            };
            return this.each(function () {
                var e, n, t = l(this);
                (e = t).find(i.itemSelector).each(function () {
                    r.push(l(this))
                }),
                    e.masonry(i),
                    "list" === i.selectorType ? u(t) : (n = t,
                        l(i.filtersGroupSelector).find("input[type=checkbox]").each(function () {
                            l(this).change(function () {
                                var e = [];
                                l(i.filtersGroupSelector).find("input[type=checkbox]").each(function () {
                                    l(this).is(":checked") && e.push("." + l(this).val())
                                });
                                var t = r;
                                0 < e.length && (t = s(e)),
                                    a(n, t)
                            })
                        }))
            })
        }
    }(window.jQuery),
    $(function () {
        "use strict";
        $(window).unload(function () {
        });
        var e = $(window).width()
            , t = $(window).height();
        $(".section.started").css({
            height: t - 60
        }),
            $(".typed-load").typed({
                stringsElement: $(".typing-load"),
                loop: !0
            }),
            $(window).load(function () {
                $(".preloader .pre-inner").fadeOut(800, function () {
                    $(".preloader").fadeOut(),
                        $("body").addClass("loaded"),
                        $(".typed-subtitle").typed({
                            stringsElement: $(".typing-subtitle"),
                            loop: !0
                        }),
                        $(".typed-bread").typed({
                            stringsElement: $(".typing-bread"),
                            showCursor: !1
                        });
                    var e = location.hash
                        , t = $(e);
                    0 == e.indexOf("#section-") && t.length && $("body, html").animate({
                        scrollTop: $(e).offset().top - 72
                    }, 400)
                })
            }),
            $("header .top-menu, .typed-bread").on("click", "a", function () {
                var e = $(this).attr("href");
                return 0 == e.indexOf("#section-") ? ($("body").hasClass("home") || (location.href = "/" + e),
                    $("body, html").animate({
                        scrollTop: $(e).offset().top - 110
                    }, 400),
                $("header").hasClass("active") && $(".menu-btn").trigger("click")) : ($("body").removeClass("loaded"),
                    setTimeout(function () {
                        location.href = "" + e
                    }, 500)),
                    !1
            }),
            $("header").on("click", ".menu-btn", function () {
                return $("header").hasClass("active") ? ($("header").removeClass("active"),
                    $("body").addClass("loaded")) : ($("header").addClass("active"),
                    $("body").removeClass("loaded")),
                    !1
            }),
            $(window).scroll(function () {
                1 <= $(this).scrollTop() ? $(".mouse_btn").fadeOut() : $(".mouse_btn").fadeIn()
            }),
            $(".section").on("click", ".mouse_btn", function () {
                $("body,html").animate({
                    scrollTop: t - 150
                }, 800)
            }),
            $("body").on({
                mouseenter: function () {
                    $(this).addClass("glitch-effect-white")
                },
                mouseleave: function () {
                    $(this).removeClass("glitch-effect-white"),
                        $(".top-menu ul li.active a.btn").addClass("glitch-effect-white")
                }
            }, "a.btn, .btn"),
            $("#cform").validate({
                rules: {
                    name: {
                        required: !0
                    },
                    message: {
                        required: !0
                    },
                    email: {
                        required: !0,
                        email: !0
                    }
                },
                success: "valid",
                submitHandler: function () {
                    $.ajax({
                        url: "mailer/feedback.php",
                        type: "post",
                        dataType: "json",
                        data: "name=" + $("#cform").find('input[name="name"]').val() + "&email=" + $("#cform").find('input[name="email"]').val() + "&message=" + $("#cform").find('textarea[name="message"]').val(),
                        beforeSend: function () {
                        },
                        complete: function () {
                        },
                        success: function (e) {
                            $("#cform").fadeOut(),
                                $(".alert-success").delay(1e3).fadeIn()
                        }
                    })
                }
            }),
            $("#comment_form").validate({
                rules: {
                    name: {
                        required: !0
                    },
                    message: {
                        required: !0
                    },
                    email: {
                        required: !0,
                        email: !0
                    }
                },
                success: "valid",
                submitHandler: function () {
                }
            });
        var n_b = $(".section.blog .box-items");
        var n_c = $(".section.clients .box-items");
        var n = $(".section.works .box-items");
        n_b.imagesLoaded(function () {
            n_b.multipleFilterMasonry({
                itemSelector: ".box-item",
                percentPosition: !0,
                gutter: 0
            })
        }),
            n_c.imagesLoaded(function () {
                n_c.multipleFilterMasonry({
                    itemSelector: ".box-item",
                    percentPosition: !0,
                    gutter: 0
                })
            }),
            n.imagesLoaded(function () {
                n.multipleFilterMasonry({
                    itemSelector: ".box-item",
                    filtersGroupSelector: ".filters",
                    percentPosition: !0,
                    gutter: 0
                })
            }),
            $(".filters label").on("change", 'input[type="checkbox"]', function () {
                $(this).is(":checked") ? $(this).parent().addClass("glitch-effect") : $(this).parent().removeClass("glitch-effect"),
                    $(".has-popup").magnificPopup({
                        type: "inline",
                        overflowY: "auto",
                        closeBtnInside: !0,
                        mainClass: "mfp-fade"
                    })
            }),
            $(".has-popup").magnificPopup({
                type: "inline",
                overflowY: "auto",
                closeBtnInside: !0,
                mainClass: "mfp-fade"
            }),
            $(window).resize(function () {
                $(window).width();
                var e = $(window).height();
                $(".section.started").css({
                    height: e - 60
                })
            }),
        e < 840 && $(".section.started").css({
            height: t - 30
        }),
        $(".section").length && $(".top-menu li a").length && $(window).on("scroll", function () {
            var n = $(window).scrollTop();
            $(".top-menu ul li a").each(function () {
                if (0 == $(this).attr("href").indexOf("#section-")) {
                    var e = $(this)
                        , t = $(e.attr("href"));
                    t.length && t.offset().top <= n + 110 && ($(".top-menu ul li").removeClass("active"),
                        e.closest("li").addClass("active")),
                    0 == n && $(".top-menu ul li").removeClass("active")
                }
            })
        }),
            $(".theme_panel .toggle_bts").on("click", "a", function () {
                if ($(this).hasClass("active"))
                    return $(this).removeClass("active"),
                        $(".theme_panel").removeClass("active"),
                        !1;
                $(this).addClass("active"),
                    $(".theme_panel").addClass("active")
            })
    });
