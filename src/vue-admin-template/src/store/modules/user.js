import { login, logout, getInfo } from '@/api/login'
import { getToken, setToken, removeToken } from '@/utils/auth'
import router, { asyncRouterMap } from '@/router'

function filterMenus(routes, serverMenus) {
  var validRoutes = routes.filter(router => {
    // debugger
    for (var index in serverMenus) {
      var serverMenu = serverMenus[index]
      if (router.menu === serverMenu.menu_path) {
        return true
      }
      if (router.children && router.children.length > 0) {
        router.children = filterMenus(router.children, serverMenus)
        if (router.children && router.children.length > 0) {
          return true
        }
      }
    }
    return false
  })
  return validRoutes
}
const user = {
  state: {
    token: getToken(),
    name: '',
    avatar: '',
    roles: [],
    routes: []
  },

  mutations: {
    SET_TOKEN: (state, token) => {
      state.token = token
    },
    SET_NAME: (state, name) => {
      state.name = name
    },
    SET_AVATAR: (state, avatar) => {
      state.avatar = avatar
    },
    SET_ROLES: (state, roles) => {
      state.roles = roles
    },
    SET_ROUTES: (state, menus) => {
      state.routes = filterMenus(asyncRouterMap, menus)
      router.addRoutes(state.routes)
    }
  },

  actions: {
    // 登录
    Login({ commit }, userInfo) {
      const username = userInfo.username.trim()
      return new Promise((resolve, reject) => {
        login(username, userInfo.password).then(response => {
          const data = response.body
          setToken(data)
          commit('SET_TOKEN', data)
          resolve()
        }).catch(error => {
          reject(error)
        })
      })
    },

    // 获取用户信息
    GetInfo({ commit, state }) {
      return new Promise((resolve, reject) => {
        getInfo(state.token).then(response => {
          const data = response.body
          if (data.roleList && data.roleList.length > 0) { // 验证返回的roles是否是一个非空数组
            commit('SET_ROLES', data.roleList)
            commit('SET_ROUTES', data.menuList)
          } else {
            reject('getInfo: roles must be a non-null array !')
          }
          commit('SET_NAME', data.nickname)
          commit('SET_AVATAR', data.avatar)
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },

    // 登出
    LogOut({ commit, state }) {
      return new Promise((resolve, reject) => {
        logout(state.token).then(() => {
          commit('SET_TOKEN', '')
          commit('SET_ROLES', [])
          removeToken()
          resolve()
        }).catch(error => {
          reject(error)
        })
      })
    },

    // 前端 登出
    FedLogOut({ commit }) {
      return new Promise(resolve => {
        commit('SET_TOKEN', '')
        removeToken()
        resolve()
      })
    }
  }
}

export default user
